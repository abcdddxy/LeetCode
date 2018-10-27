public class lee154_FindMinArray_hard {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) return nums[left];
            int mid = (left + right) / 2;
            if (nums[left] < nums[mid]) left = mid + 1;
            else if(nums[left] == nums[mid]) left += 1;
            else right = mid;
        }
        return nums[left];
    }
}
