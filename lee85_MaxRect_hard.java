import java.util.Arrays;

public class lee85_MaxRect_hard {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int h = matrix.length, w = matrix[0].length;
        int res = 0;
        int[] left = new int[w], right = new int[w], height = new int[w];
        Arrays.fill(right, w);

        for (int i = 0; i < h; i++) {
            int leftBound = 0, rightBound = w + 1;
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                    left[j] = Math.max(left[j], leftBound);
                    right[j] = Math.min(right[j], rightBound);
                } else {
                    height[j] = 0;
                    leftBound = j + 1;
                    rightBound = j;
                }
                res = Math.max((right[j] - left[j]) * height[j], res);
            }
        }
        return res;
    }
}
