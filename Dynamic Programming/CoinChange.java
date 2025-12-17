
public class CoinChange {
    public static int solveUsingRec(int coins[], int amount) {
        if (amount == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int recursionAns;
            if (amount - coins[i] >= 0) {
                recursionAns = solveUsingRec(coins, amount - coins[i]);
                if (recursionAns != Integer.MAX_VALUE) {
                    ans = Math.min(recursionAns + 1, ans);
                }
            }
        }

        return ans;
    }

    public static int solveUsingMemo(int coins[], int amount, int dp[]) {
        if (amount == 0) {
            return 0;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int recursionAns;
            if (amount - coins[i] >= 0) {
                recursionAns = solveUsingMemo(coins, amount - coins[i], dp);
                if (recursionAns != Integer.MAX_VALUE) {
                    ans = Math.min(recursionAns + 1, ans);
                }
            }
        }

        dp[amount] = ans;

        return ans;
    }

    public static int solveUsingTabu(int coins[], int amount) {
        int dp[] = new int[amount + 1];
        for (int value = 1; value <= amount; value++) {
            int mini = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (value - coins[i] >= 0) {
                    int recursionKaAnswer = dp[value - coins[i]];
                    if (recursionKaAnswer != Integer.MAX_VALUE) {
                        mini = Math.min(mini, recursionKaAnswer + 1);
                    }
                }
            }
            dp[value] = mini;
        }

        return dp[amount];
    }

    public static int coinChange(int[] coins, int amount) {
        // int ans = solveUsingRec(coins, amount);
        // int dp[] = new int[amount + 1];
        // Arrays.fill(dp, -1);
        int ans = solveUsingTabu(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 5 }, amount = 11;
        System.out.println(coinChange(coins, amount));
        int coin[] = { 2 };
        System.out.println(coinChange(coin, 3));
    }
}
