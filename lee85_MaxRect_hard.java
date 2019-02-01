import java.util.Arrays;

public class lee85_MaxRect_hard {
    //长宽法
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int h = matrix.length, w = matrix[0].length;
        int res = 0;
        int[] left = new int[w], right = new int[w], height = new int[w];
        Arrays.fill(right, w);

        for (int i = 0; i < h; i++) {
            int leftBound = 0, rightBound = w;
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], leftBound);
                } else {
                    left[j] = 0;
                    leftBound = j + 1;
                }
            }
            for (int j = w - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rightBound);
                } else {
                    right[j] = w;
                    rightBound = j;
                }
            }
            for (int j = 0; j < w; j++) {
                res = Math.max((right[j] - left[j]) * height[j], res);
            }
        }
        return res;
    }

    //计数法
    public int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int h = matrix.length, w = matrix[0].length;
        int res = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (matrix[i][j] == '1') {
                    matrix[i][j] = (char) (matrix[i][j-1] + 1);
                } else {
                    matrix[i][j] = '0';
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int min = matrix[i][j] - '0';
                if (min > 0) {
                    res = Math.max(res, min);
                    for (int k = i-1; k >= 0 && matrix[k][j] != '0'; k--) {
                        min = Math.min(min, matrix[k][j] - '0');
                        res = Math.max(res, min * (i-k+1));
                    }
                }
            }
        }
        return res;
    }
}
