import java.util.Arrays;

public class lee279_PerfectSquares_medium {
    public int numSquares(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 0; i < n; i++) {
            int tmp = 1;
            while (i + tmp * tmp <= n) {
                if (dp[i + tmp * tmp] == 0) dp[i + tmp * tmp] = dp[i] + 1;
                else dp[i + tmp * tmp] = Math.min(dp[i] + 1, dp[i + tmp * tmp]);
                tmp++;
            }
            System.out.println("dp = [" + Arrays.toString(dp) + "]");
        }
        return dp[n];
    }
}
