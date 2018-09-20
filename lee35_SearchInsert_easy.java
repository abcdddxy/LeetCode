public class lee35_SearchInsert_easy {
    public int searchInsert(int[] nums, int target) {
        int i;

        for (i = 0; i < nums.length; ) {
            if(nums[i] < target){
                i++;
            }else {
                return i;
            }
        }
        return i;
    }
}
