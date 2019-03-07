public class lee34_FindFirstLastNum_medium {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int leftIdx = extremeInsertionIndex(nums, target, true);
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return ans;
        }
        ans[0] = leftIdx;
        ans[1] = extremeInsertionIndex(nums, target, false) - 1;
        return ans;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
