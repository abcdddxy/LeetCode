public class offer1_FindList {
    // 暴力搜索
    public boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) return false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) return true;
            }
        }
        return false;
    }

    // 二分查找
    public boolean Find2(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) return false;
        for (int i = 0; i < array.length; i++) {
            if (binarySearch(target, array, i)) return true;
        }
        return false;
    }

    private boolean binarySearch(int target, int[][] array, int row) {
        if (array[row][0] > target) return false;
        if (array[row][0] == target) return true;
        int low = 0, high = array[row].length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == array[row][mid]) return true;
            else if (target > array[row][mid]) low = mid + 1;
            else if (target < array[row][mid]) high = mid - 1;
        }
        return false;
    }
}
