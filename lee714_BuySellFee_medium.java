import java.util.Arrays;

public class lee714_BuySellFee_medium {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len == 0) return 0;
        int[] buy = new int[len], sell = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                buy[i] = -prices[i];
                sell[i] = 0;
            } else {
                buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
                sell[i] = Math.max(sell[i - 1], prices[i] + buy[i] - fee);
            }
        }
        System.out.println("buy = " + Arrays.toString(buy) + "sell = " + Arrays.toString(sell));

        return sell[len - 1];
    }

    //空间复杂度为O(1)的做法
    public int maxProfit2(int[] prices, int fee) {
        int len = prices.length;
        if (len == 0) return 0;
        int buy = Integer.MIN_VALUE, sell = 0;

        for (int p : prices) {
            buy = Math.max(buy, sell - p);
            sell = Math.max(sell, p + buy - fee);
        }

        return sell;
    }
}
