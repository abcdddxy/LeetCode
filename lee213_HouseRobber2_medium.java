public class lee213_HouseRobber2_medium {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        else if(len == 1) return nums[0];

        return Math.max(robN(nums, 0, len - 1), robN(nums, 1, len));
    }

    public int robN(int[] nums, int start, int end) {
        int rob = 0, noRob = 0;
        for (int i = start; i < end; i++) {
            int tmp = rob;
            rob = Math.max(rob, noRob + nums[i]);
            noRob = tmp;
        }
        return rob;
    }
}
