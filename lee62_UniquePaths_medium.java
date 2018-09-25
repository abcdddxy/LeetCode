import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Status2 {
    public int m;
    public int n;

    Status2(int m, int n) {
        this.m = m;
        this.n = n;
    }
}

public class lee62_UniquePaths_medium {
    //递归时间超了
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    //DFS时间也超了
    public int uniquePaths2(int m, int n) {
        Stack<Status2> sta = new Stack<Status2>();
        int res = 0;
        sta.push(new Status2(m, n));

        while (!sta.isEmpty()) {
            Status2 tmp = sta.pop();
            if (tmp.m == 1 || tmp.n == 1) {
                res++;
            } else {
                sta.push(new Status2(tmp.m - 1, tmp.n));
                sta.push(new Status2(tmp.m, tmp.n - 1));
            }
        }
        return res;
    }

    //本质上是个排列组合问题C(m-1)(m+n-2)
    public int uniquePaths3(int m, int n) {
        double[] res = new double[m + n - 1];
        if (m == 1 || n == 1) {
            return 1;
        }

        res[0] = 1;
        for (int i = 1; i < m + n - 1; i++) {
            res[i] = i * res[i - 1];
            System.out.println("i = [" + i + "], res[i] = [" + res[i] + "]");
        }

        return (int) Math.round(res[m + n - 2] / (res[m - 1] * res[n - 1]));
    }

    //dp
    public int uniquePaths4(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
