public class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxPrice = 0;
        int buyStock = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (buyStock < prices[i]) {
                int currPrice = prices[i] - buyStock;
                maxPrice = Math.max(currPrice, maxPrice);
            } else {
                buyStock = prices[i];
            }
        }

        return maxPrice;
    }

    public static int solve(int prices[], int index, int buyStock, int maxPrice) {
        if (index >= prices.length) {
            return maxPrice;
        }

        if (buyStock < prices[index]) {
            int currPrice = prices[index] - buyStock;
            maxPrice = Math.max(currPrice, maxPrice);
        } else {
            buyStock = prices[index];
        }

        return solve(prices, index + 1, buyStock, maxPrice);
    }

    public static int maxProfitRE(int[] prices) {
        int buyStock = Integer.MAX_VALUE;
        int maxPrice = 0;
        return solve(prices, 0, buyStock, maxPrice);
    }

    public static void main(String[] args) {
        int prices1[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfitRE(prices1));
        int prices2[] = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfitRE(prices2));
    }
}
