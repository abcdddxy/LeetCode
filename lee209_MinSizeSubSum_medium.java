public class lee209_MinSizeSubSum_medium {
    // 暴力求解
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int minLen = Integer.MAX_VALUE;
        int tmp, tmpLen;
        for (int i = 0; i < nums.length; i++) {
            tmp = 0;
            tmpLen = 0;
            for (int j = i; j < nums.length; j++) {
                System.out.println("s = [" + s + "], tmp = [" + tmp + "]");
                tmp += nums[j];
                tmpLen += 1;
                if (tmp >= s) {
                    minLen = Math.min(minLen, tmpLen);
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // 二点法
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                minLen = Math.min(minLen, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
