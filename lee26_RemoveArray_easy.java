public class lee26_RemoveArray_easy {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1, preNum = nums[0];
        for (int i : nums) {
            if(i != preNum) {
                preNum = i;
                nums[res] = preNum;
                res ++;
            }
        }
        return res;
    }
}
