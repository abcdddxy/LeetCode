public class offer10_RectCover {
    public int RectCover(int target) {
        if (target <= 1) return target;
        int[] dp = new int[target];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < target; i++) dp[i] = dp[i - 2] + dp[i - 1];
        return dp[target - 1];
    }
}
