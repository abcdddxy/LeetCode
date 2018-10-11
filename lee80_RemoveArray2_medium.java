public class lee80_RemoveArray2_medium {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int res = 2, preNum = nums[1], prePreNum = nums[0];
        for (int i = 2; i < nums.length; i++) {
            System.out.println("nums = [" + nums[i] + "], preNum = [" + preNum + "], prePreNum = [" + prePreNum + "]");
            if (nums[i] != preNum || nums[i] != prePreNum) {
                nums[res] = preNum;
                res++;
            }
            prePreNum = preNum;
            preNum = nums[i];
            if (i == nums.length - 1) nums[res] = preNum;
        }
        return res;
    }
}
