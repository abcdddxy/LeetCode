public class lee123_BuySell3_hard {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int min = prices[0];
        int[] left = new int[len];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        int max = prices[len - 1];
        int[] right = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, left[i] + right[i]);
        }
        return ans;
    }

    //牛逼闪闪的做法
    public int maxProfit2(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i : prices) {
            buy1 = Math.max(buy1, -i);
            sell1 = Math.max(sell1, i + buy1);
            buy2 = Math.max(buy2, sell1 - i);
            sell2 = Math.max(sell2, i + buy2);
            System.out.println("buy1 = [" + buy1 + "]"+"sell1 = [" + sell1 + "]"+"buy2 = [" + buy2 + "]"+"sell2 = [" + sell2 + "]");
        }
        return sell2;
    }
}
