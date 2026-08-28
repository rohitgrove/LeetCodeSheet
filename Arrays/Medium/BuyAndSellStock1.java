public class BuyAndSellStock1 {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyStock = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (buyStock < prices[i]) {
                int currProfit = prices[i] - buyStock;
                maxProfit = Math.max(currProfit, maxProfit);
            } else {
                buyStock = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int prices1[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices1));
        int prices2[] = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices2));
    }
}
