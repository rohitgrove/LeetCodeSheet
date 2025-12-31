
public class CoinChange2 {
    public static int solveUsingRec(int coins[], int idx, int amount) {
        if (idx < 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        int take = 0;
        if (amount >= coins[idx]) {
            take = solveUsingRec(coins, idx, amount - coins[idx]);
        }

        int notTake = solveUsingRec(coins, idx - 1, amount);
        return take + notTake;
    }

    public static int solveUsingMemo(int coins[], int idx, int amount,int dp[][]) {
        if (idx < 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }

        int take = 0;
        if (amount >= coins[idx]) {
            take = solveUsingMemo(coins, idx, amount - coins[idx], dp);
        }

        int notTake = solveUsingMemo(coins, idx - 1, amount, dp);
        dp[idx][amount] = take + notTake;
        return dp[idx][amount];
    }

    public static int solveUsingTabu(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }

        for (int idx = 1; idx < coins.length + 1; idx++) {
            for (int amt = 1; amt < amount + 1; amt++) {
                int take = 0;
                if (amt >= coins[idx - 1]) {
                    take = dp[idx][amt - coins[idx - 1]];
                }
                int notTake = dp[idx - 1][amt];
                dp[idx][amt] = take + notTake;
            }
        }
        return dp[coins.length][amount];
    }


    public static int change(int amount, int[] coins) {
        // return solveUsingRec(coins, coins.length - 1, amount);
        // int dp[][] = new int[coins.length + 1][amount + 1];
        // for (int[] row : dp) {
            // Arrays.fill(row, -1);
        // }
        // return solveUsingMemo(coins, coins.length - 1, amount, dp);
        return solveUsingTabu(amount, coins);
    }

    public static void main(String[] args) {
        int amount = 5;
        int coins[] = { 1, 2, 5 };
        System.out.println(change(amount, coins));
    }
}
