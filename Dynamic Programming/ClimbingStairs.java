public class ClimbingStairs {
    public static int solveUsingRec(int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int way1 = solveUsingRec(n - 1);
        int way2 = solveUsingRec(n - 2);
        return way1 + way2;
    }

    public static int solveUsingMemo(int n, int dp[]) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int way1 = solveUsingMemo(n - 1, dp);
        int way2 = solveUsingMemo(n - 2, dp);
        dp[n] = way1 + way2;
        return dp[n];
    }

    public static int solveUsingTabu(int n) {
        int dp[] = new int[n + 1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int way1 = dp[i - 1];
            int way2 = 0;
            if (i > 1) {
                way2 = dp[i - 2];
            }
            dp[i] = way1 + way2;
        }

        return dp[n];
    }

    public static int solveUsingTabuSO(int n) {
        int step1 = 1;
        int step2 = 0;

        for (int i = 1; i <= n; i++) {
            int next = step1 + step2;
            step2 = step1;
            step1 = next;
        }

        return step1;
    }

    public static int climbStairs(int n) {
        // return solveUsingRec(n);
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return solveUsingMemo(n, dp);
        return solveUsingTabuSO(n);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }
}
