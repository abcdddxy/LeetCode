import java.util.Arrays;

public class lee221_MaxSquare_medium {
    //从上个题改进
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int h = matrix.length, w = matrix[0].length;
        int res = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (matrix[i][j] == '1') {
                    matrix[i][j] = (char) (matrix[i][j - 1] + 1);
                } else {
                    matrix[i][j] = '0';
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int min = matrix[i][j] - '0';
                if (min > 0) {
                    for (int k = i; k >= 0 && matrix[k][j] != '0'; k--) {
                        min = Math.min(min, matrix[k][j] - '0');
                        if (min == (i - k + 1)) {
                            System.out.println("min = [" + min + "]" + (i - k + 1));
                            res = Math.max(res, min * (i - k + 1));
                        }
                    }
                }
            }
        }
        return res;
    }

    //dp
    public int maximalSquare2(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int h = matrix.length, w = matrix[0].length;
        int res = 0;
        int[][] dp = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    if (i > 0 && j > 0) dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return res * res;
    }

}
