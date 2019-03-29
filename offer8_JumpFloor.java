public class offer8_JumpFloor {
    public int JumpFloor(int target) {
        int[] dp = new int[target + 2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= target + 1; i++) dp[i] = dp[i - 2] + dp[i - 1];
        return dp[target + 1];
    }
}
