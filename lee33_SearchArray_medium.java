public class lee33_SearchArray_medium {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[left] <= target && nums[mid] >= target) right = mid - 1;
            else if(nums[right] >= target && nums[mid] >= target) left = mid + 1;
            else if(nums[right] <= target && nums[mid] <= target) left = mid + 1;
        }

        return -1;
    }
}
