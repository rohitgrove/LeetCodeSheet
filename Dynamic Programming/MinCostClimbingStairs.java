public class MinCostClimbingStairs {
    public static int solveUsingRec(int idx, int cost[]) {
        if (idx == 0 || idx == 1) {
            return cost[idx];
        }

        int step1 = solveUsingRec(idx - 1, cost);
        int step2 = solveUsingRec(idx - 2, cost);
        int ans = cost[idx] + Math.min(step1, step2);
        return ans;
    }

    public static int solveUsingMemo(int idx, int cost[], int dp[]) {
        if (idx == 0 || idx == 1) {
            return cost[idx];
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int step1 = solveUsingMemo(idx - 1, cost, dp);
        int step2 = solveUsingMemo(idx - 2, cost, dp);
        dp[idx] = cost[idx] + Math.min(step1, step2);
        return dp[idx];
    }

    public static int solveUsingTabu(int cost[]) {
        int dp[] = new int[cost.length + 1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int idx = 2; idx < cost.length; idx++) {
            int step1 = dp[idx - 1];
            int step2 = dp[idx - 2];
            dp[idx] = cost[idx] + Math.min(step1, step2);
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static int solveUsingTabuSO(int cost[]) {
        int step1 = cost[0];
        int step2 = cost[1];

        for (int idx = 2; idx < cost.length; idx++) {
            int next = cost[idx] + Math.min(step1, step2);
            step1 = step2;
            step2 = next;
        }

        return Math.min(step1, step2);
    }

    public static int minCostClimbingStairs(int[] cost) {
        // return Math.min(solveUsingRec(cost.length - 1, cost),
        // solveUsingRec(cost.length - 2, cost));
        // int dp[] = new int[cost.length + 1];
        // Arrays.fill(dp, -1);
        // return Math.min(solveUsingMemo(cost.length - 1, cost, dp), solveUsingMemo(cost.length - 2, cost, dp));
        return solveUsingTabuSO(cost);
    }

    public static void main(String[] args) {
        int cost1[] = { 10, 15, 20 };
        System.out.println(minCostClimbingStairs(cost1));
        int cost2[] = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println(minCostClimbingStairs(cost2));
    }
}
