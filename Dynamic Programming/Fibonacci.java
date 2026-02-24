public class Fibonacci {
    public static int solveUsingRec(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int ans = solveUsingRec(n - 1) + solveUsingRec(n - 2);
        return ans;
    }

    public static int solveUsingMemo(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solveUsingMemo(n - 1, dp) + solveUsingMemo(n - 2, dp);
        return dp[n];
    }

    public static int solveUsingTabu(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int index = 2; index <= n; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }

        return dp[n];
    }

    public static int solveUsingTabuSO(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int ans = 0;
        int prev = 0;
        int curr = 1;

        for (int index = 2; index <= n; index++) {
            ans = curr + prev;
            prev = curr;
            curr = ans;
        }

        return ans;
    }

    public static int fib(int n) {
        // return solveUsingRec(n);
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return solveUsingMemo(n, dp);
        return solveUsingTabuSO(n);
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
    }
}
