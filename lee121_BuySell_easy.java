public class lee121_BuySell_easy {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int n = prices.length;
        int[] maxPrice = new int[n];
        int best = 0;
        maxPrice[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice[i] = Math.max(maxPrice[i + 1], prices[i]);
            best = Math.max(best, maxPrice[i] - prices[i]);
        }
        return best;
    }
}
