import java.util.Arrays;

public class lee300_LongIncreaseSub_medium {
    //1维dp,O(n^2)
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, ans = 1;
        if (len <= 1) return len;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                }
                ans = Math.max(ans, dp[j]);
            }
            System.out.println("dp = " + Arrays.toString(dp));
        }

        return ans;
    }

    //暴力解,O(2^n)
    public int lengthOfLIS2(int[] nums) {
        return forceLIS(nums, Integer.MIN_VALUE, 0);
    }

    public int forceLIS(int[] nums, int prev, int cur) {
        if (cur == nums.length) return 0;

        int len1 = 0, len2 = 0;
        if (nums[cur] > prev) len1 = 1 + forceLIS(nums, nums[cur], cur + 1);
        len2 = forceLIS(nums, prev, cur + 1);

        return Math.max(len1, len2);
    }

    //2维dp,O(n^2)
    public int lengthOfLIS3(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int[] i : dp) Arrays.fill(i, -1);
        return forceDpLIS(nums, -1, 0, dp);
    }

    public int forceDpLIS(int[] nums, int prev, int cur, int[][] dp) {
        if (cur == nums.length) return 0;
        if (dp[prev + 1][cur] > 0) return dp[prev + 1][cur];

        int len1 = 0, len2 = 0;
        if (prev < 0 || nums[cur] > nums[prev]) len1 = 1 + forceDpLIS(nums, cur, cur + 1, dp);
        len2 = forceDpLIS(nums, prev, cur + 1, dp);

        dp[prev + 1][cur] = Math.max(len1, len2);
        return dp[prev + 1][cur];
    }

    //dp + 二分搜索,O(nlogn)
    public int lengthOfLIS4(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int i : nums) {
            int order = Arrays.binarySearch(dp, 0, len, i);
            if (order < 0) order = -(order + 1);
            dp[order] = i;
            if (order == len) len++;
            System.out.println("dp = [" + Arrays.toString(dp) + "]");
        }

        return len;
    }
}
