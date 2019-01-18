public class lee304_RangeSumQuery2_medium {

    private int[][] sum;

    public lee304_RangeSumQuery2_medium(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        sum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) sum[i][j] = matrix[i][j];
                else sum[i][j] = sum[i][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int i = 0; i <= row2 - row1; i++) ans += col1 == 0 ? sum[row1 + i][col2] : sum[row1 + i][col2] - sum[row1 + i][col1 - 1];

        return ans;
    }
}
