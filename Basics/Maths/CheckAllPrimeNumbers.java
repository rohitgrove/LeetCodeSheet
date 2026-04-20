import java.util.Arrays;

public class CheckAllPrimeNumbers {
    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean []isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        int count = 0;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                int j = i * i;
                while (j < n) {
                    isPrime[j] = false;
                    j += i;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
