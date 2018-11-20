import java.util.Arrays;

public class lee188_BuySell4_hard {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) return 0;
        if (k > prices.length / 2) {
            int ans = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) ans += prices[i] - prices[i - 1];
            }
            return ans;
        }
        int[] sell = new int[k];
        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i : prices) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    buy[j] = Math.max(buy[j], -i);
                    sell[j] = Math.max(sell[j], i + buy[j]);
                } else {
                    buy[j] = Math.max(buy[j], sell[j - 1] - i);
                    sell[j] = Math.max(sell[j], i + buy[j]);
                }
                System.out.println("buy = " + Arrays.toString(buy) + "sell = " + Arrays.toString(sell));
            }
        }
        return sell[k - 1];
    }

    //dp
    public int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        if (k == 0 || n == 0) return 0;
        if (k > n / 2) {
            int ans = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) ans += prices[i] - prices[i - 1];
            }
            return ans;
        }

        int[][] global = new int[n][k + 1];
        int[][] local = new int[n][k + 1];

        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j < k + 1; j++) {
                //注意第i天j笔交易等于i-1天j笔交易
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(0, diff), local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        System.out.println("global = " + Arrays.deepToString(global) + "local = " + Arrays.deepToString(local));

        return global[n - 1][k];
    }
}