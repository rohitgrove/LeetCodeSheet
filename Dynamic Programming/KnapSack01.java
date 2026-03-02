public class KnapSack01 {
    public static int solveUsingRec(int capacity, int val[], int wt[], int index, int n) {
        if (index == n - 1) {
            if (wt[index] <= capacity) {
                return val[index];
            } else {
                return 0;
            }
        }

        int include = 0;
        if (wt[index] <= capacity) {
            include = val[index] + solveUsingRec(capacity - wt[index], val, wt, index + 1, n);
        }

        int exclude = solveUsingRec(capacity, val, wt, index + 1, n);
        return Math.max(include, exclude);
    }

    public static int solveUsingMemo(int capacity, int val[], int wt[], int index, int n, int dp[][]) {
        if (index == n - 1) {
            if (wt[index] <= capacity) {
                return val[index];
            } else {
                return 0;
            }
        }

        if (dp[capacity][index] != -1) {
            return dp[capacity][index];
        }

        int include = 0;
        if (wt[index] <= capacity) {
            include = val[index] + solveUsingMemo(capacity - wt[index], val, wt, index + 1, n, dp);
        }

        int exclude = solveUsingMemo(capacity, val, wt, index + 1, n, dp);
        dp[capacity][index] = Math.max(include, exclude);
        return dp[capacity][index];
    }

    public static int solveUsingTabu(int capacity, int val[], int wt[], int n) {
        int dp[][] = new int[capacity + 1][n + 1];

        for (int cap = 0; cap <= capacity; cap++) {
            for (int index = n - 1; index >= 0; index--) {
                int include = 0;
                if (wt[index] <= cap) {
                    include = val[index] + dp[cap - wt[index]][index + 1];
                }

                int exclude = dp[cap][index + 1];
                dp[cap][index] = Math.max(include, exclude);
            }
        }

        return dp[capacity][0];
    }

    public static int solveUsingTabuSO1(int capacity, int val[], int wt[], int n) {
        int next[] = new int[capacity + 1];
        int curr[] = new int[capacity + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int cap = 0; cap <= capacity; cap++) {
                int include = 0;
                if (wt[index] <= cap) {
                    include = val[index] + next[cap - wt[index]];
                }
                int exclude = next[cap];
                curr[cap] = Math.max(include, exclude);
            }
            next = curr.clone();
        }

        return curr[capacity];
    }

    public static int solveUsingTabuSO2(int capacity, int val[], int wt[], int n) {
        int next[] = new int[capacity + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int cap = capacity; cap >= 0; cap--) {
                // inc / exc
                int include = 0;
                if (wt[index] <= cap) {
                    include = val[index] + next[cap - wt[index]];
                }
                int exclude = 0 + next[cap];
                next[cap] = Math.max(include, exclude);
            }
        }

        return next[capacity];
    }

    public static int knapsack(int capacity, int val[], int wt[]) {
        // int index = 0;
        int n = wt.length;
        // return solveUsingRec(capacity, val, wt, index, n);

        // int dp[][] = new int[capacity + 1][n + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        // return solveUsingMemo(capacity, val, wt, index, n, dp);
        return solveUsingTabuSO2(capacity, val, wt, n);
    }

    public static void main(String[] args) {
        int capacity1 = 50, weight1[] = { 10, 20, 30 }, profit1[] = { 60, 100, 120 }; // 220
        System.out.println(knapsack(capacity1, profit1, weight1));
        int capacity2 = 5, weight2[] = { 5, 4, 2, 3 }, profit2[] = { 10, 40, 30, 50 }; // 80
        System.out.println(knapsack(capacity2, profit2, weight2));
        int capacity3 = 6, weight3[] = { 1, 2, 3 }, profit3[] = { 10, 15, 40 }; // 65
        System.out.println(knapsack(capacity3, profit3, weight3));
    }
}
