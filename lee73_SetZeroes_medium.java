import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lee73_SetZeroes_medium {
    //O(mn+(m+n)(m+n))
    public void setZeroes(int[][] matrix) {
        List<Integer> rows = new LinkedList<>(), cols = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < rows.size(); i++) {
            int p = rows.get(i), q = cols.get(i);
            for (int j = 0; j < matrix.length; j++) matrix[j][q] = 0;
            for (int j = 0; j < matrix[0].length; j++) matrix[p][j] = 0;
        }
    }

    //O(2mn)，注意j=1这个边界条件
    public void setZeroes2(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int col0 = 1;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}
