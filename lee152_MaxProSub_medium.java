public class lee152_MaxProSub_medium {
    //超时了
    public int maxProduct(int[] nums) {
        int n = nums.length, maxNum = Integer.MIN_VALUE;
        if (n == 0) return 0;
        int[][] pro = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n - i; j++) {
                if (j == 0) pro[n - 1 - i][j] = nums[i];
                else pro[n - 1 - i][j] = nums[i] * pro[n - 2 - i][j - 1];
                maxNum = Math.max(maxNum, pro[n - 1 - i][j]);
            }
        }
        return maxNum;
    }

    public int maxProduct2(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length, maxNum = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE;
        if (n == 0) return 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) maxNum = minNum = nums[i];
            else {
                int preMax = maxNum, preMin = minNum;
                maxNum = Math.max(nums[i], Math.max(preMax * nums[i], preMin * nums[i]));
                minNum = Math.min(nums[i], Math.min(preMax * nums[i], preMin * nums[i]));
            }
            ans = Math.max(ans, maxNum);
        }
        return ans;
    }
}
