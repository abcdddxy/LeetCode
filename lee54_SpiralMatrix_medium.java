import java.util.LinkedList;
import java.util.List;

public class lee54_SpiralMatrix_medium {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0) {
            return res;
        }

        int m = matrix.length, n = matrix[0].length;
        int p = 0, q = 0; //p行，q列
        int pStart = 0, qStart = 0, pEnd = m, qEnd = n;
        int flag = 0; //0右，1下，2左，3上

        for (int i = 0; i < m * n; i++) {
            res.add(matrix[p][q]);
            switch (flag) {
                case 0:
                    if (q < qEnd - 1) {
                        q++;
                    } else {
                        p++;
                        flag = 1;
                        qEnd--;
                        pStart++;
                    }
                    break;
                case 1:
                    if (p < pEnd - 1) {
                        p++;
                    } else {
                        q--;
                        flag = 2;
                        pEnd--;
                    }
                    break;
                case 2:
                    if (q > qStart) {
                        q--;
                    } else {
                        p--;
                        flag = 3;
                        qStart++;
                    }
                    break;
                case 3:
                    if (p > pStart) {
                        p--;
                    } else {
                        q++;
                        flag = 0;
                    }
                    break;
                default:
                    break;
            }
        }
        return res;
    }

    //比较简单的循环
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0) {
            return res;
        }

        int pStart = 0, qStart = 0, pEnd = matrix.length - 1, qEnd = matrix[0].length - 1;
        while (pStart <= pEnd && qStart <= qEnd) {
            //右
            for (int i = qStart; i <= qEnd; i++) {
                res.add(matrix[pStart][i]);
            }
            pStart++;
            //下
            for (int i = pStart; i <= pEnd; i++) {
                res.add(matrix[i][qEnd]);
            }
            qEnd--;
            //左
            if (pStart <= pEnd) {
                for (int i = qEnd; i >= qStart; i--) {
                    res.add(matrix[pEnd][i]);
                }
            }
            pEnd--;
            //上
            if (qStart <= qEnd) {
                for (int i = pEnd; i >= pStart; i--) {
                    res.add(matrix[i][qStart]);
                }
            }
            qStart++;
        }

        return res;
    }
}
