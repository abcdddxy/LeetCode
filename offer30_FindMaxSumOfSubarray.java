public class offer30_FindMaxSumOfSubarray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        int max = array[0];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] <= 0) dp[i] = array[i];
            else dp[i] = dp[i - 1] + array[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
