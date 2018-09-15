import java.util.Arrays;

public class lee16_3SumClosest_medium {
    public int threeSumClosest(int[] nums, int target) {
        int minRes = Integer.MAX_VALUE;
        int res = 0, tmp;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                tmp = nums[i] + nums[j] + nums[k];
                if (tmp > target) {
                    k--;
                } else if (tmp < target) {
                    j++;
                } else {
                    return target;
                }
                if (minRes > Math.abs(tmp - target)) {
                    res = tmp;
                    minRes = Math.abs(tmp - target);
                }
            }
        }
        return res;
    }
}
