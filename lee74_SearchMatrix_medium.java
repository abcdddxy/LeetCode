public class lee74_SearchMatrix_medium {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int flag = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == target) return true;
            else if (matrix[i][0] < target) flag = i;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[flag][i] == target) return true;
        }
        return false;
    }

    //看成一个数组二分搜索
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int start = 0, end = row * col - 1, mid;

        while (start <= end){
            mid = (start + end) / 2;
            if(matrix[mid/col][mid%col] == target) return true;
            else if(matrix[mid/col][mid%col] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
