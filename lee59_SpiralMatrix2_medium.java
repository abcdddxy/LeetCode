public class lee59_SpiralMatrix2_medium {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int no = 1;
        if (n == 0) {
            return res;
        }

        int pStart = 0, qStart = 0, pEnd = n - 1, qEnd = n - 1;
        while (pStart <= pEnd && qStart <= qEnd) {
            //右
            for (int i = qStart; i <= qEnd; i++) {
                res[pStart][i] = no;
                no++;
            }
            pStart++;
            //下
            for (int i = pStart; i <= pEnd; i++) {
                res[i][qEnd] = no;
                no++;
            }
            qEnd--;
            //左
            if (pStart <= pEnd) {
                for (int i = qEnd; i >= qStart; i--) {
                    res[pEnd][i] = no;
                    no++;
                }
            }
            pEnd--;
            //上
            if (qStart <= qEnd) {
                for (int i = pEnd; i >= pStart; i--) {
                    res[i][qStart] = no;
                    no++;
                }
            }
            qStart++;
        }
        return res;
    }
}
