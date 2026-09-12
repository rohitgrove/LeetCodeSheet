import java.util.Arrays;

public class MinimumDaysToScoreExactlyNPoints {
    public static int solveUsingTabu(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int points = 1; points <= n; points++) {
            for (int k = 1; k * (k + 1) / 2 <= points; k++) {
                int streakPoints = k * (k + 1) / 2;
                if (dp[points - streakPoints] != Integer.MAX_VALUE) {
                    dp[points] = Math.min(dp[points], dp[points - streakPoints] + k + 1);
                }
            }
        }

        return dp[n] - 1;
    }

    public static int solveUsingMemo(int n, int dp[]) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = 1; k * (k + 1) / 2 <= n; k++) {
            int points = k * (k + 1) / 2;
            int days = solveUsingMemo(n - points, dp) + k + 1;
            ans = Math.min(ans, days);
        }

        return dp[n] = ans;
    }

    public static int minDays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // Har streak ke baad skip count kar rahe hain,
        // isliye end mein 1 subtract karenge.
        return solveUsingMemo(n, dp) - 1;
    }

    public static void main(String[] args) {
        System.out.println(minDays(2));
        System.out.println(minDays(9));
        System.out.println(minDays(12));
    }
}
