import java.util.Arrays;

public class lee309_BuySellCooldown_medium {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int[] buy = new int[len], sell = new int[len], cool = new int[len];
        buy[0] = -prices[0];
        sell[0] = cool[0] = 0;

        for (int i = 1; i < len; i++) {
            buy[i] = Math.max(buy[i - 1], cool[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], prices[i] + buy[i - 1]);
            cool[i] = Math.max(cool[i - 1], Math.max(buy[i - 1], sell[i - 1]));
        }
        System.out.println("buy = " + Arrays.toString(buy) + "sell = " + Arrays.toString(sell) + "cool = " + Arrays.toString(cool));

        return sell[len - 1];
    }

    //空间复杂度O(1)的做法，更新慢一拍（cooldown）
    public int maxProfit2(int[] prices) {
        int pre_buy, pre_sell = 0, buy = Integer.MIN_VALUE, sell = 0;
        for (int p : prices) {
            pre_buy = buy;
            buy = Math.max(pre_buy, pre_sell - p);
            pre_sell = sell;
            sell = Math.max(pre_sell, p + pre_buy);
            System.out.println("buy = " + buy + "sell = " + sell);
        }

        return sell;
    }
}
