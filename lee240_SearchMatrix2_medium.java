public class lee240_SearchMatrix2_medium {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        for (int[] nums :matrix) {
            if (nums[0] == target || nums[col - 1] == target) return true;
            else if (nums[0] < target || nums[col - 1] > target) {
                if (binarySearch(nums, target)) return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
