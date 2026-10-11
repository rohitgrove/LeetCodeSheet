import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSubsetSelection2 {
    public static List<Integer> maxPrimeSubset(int n, int s) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        if (n >= 1) {
            prime[1] = false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        List<Integer>[] dp = new ArrayList[s + 1];
        dp[0] = new ArrayList<>();

        for (int p = 2; p <= n; p++) {
            if (!prime[p] || p > s) {
                continue;
            }

            for (int sum = s; sum >= p; sum--) {
                if (dp[sum - p] == null) {
                    continue;
                }

                List<Integer> candidate = new ArrayList<>(dp[sum - p]);
                candidate.add(p);

                if (dp[sum] == null || candidate.size() < dp[sum].size()
                        || (candidate.size() == dp[sum].size() && lexSmaller(candidate, dp[sum]))) {
                    dp[sum] = candidate;
                }
            }
        }

        for (int sum = s; sum >= 1; sum--) {
            if (dp[sum] != null) {
                return dp[sum];
            }
        }

        return new ArrayList<>();
    }

    public static boolean lexSmaller(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(maxPrimeSubset(7, 20));
        System.out.println(maxPrimeSubset(15, 18));
        System.out.println(maxPrimeSubset(5, 1));
        System.out.println(maxPrimeSubset(10, 10));
        System.out.println(maxPrimeSubset(10, 12));
        System.out.println(maxPrimeSubset(3, 5));
    }
}
