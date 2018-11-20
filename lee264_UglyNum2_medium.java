import java.util.LinkedList;
import java.util.List;

public class lee264_UglyNum2_medium {
    //超时
    public int nthUglyNumber(int n) {
        boolean[] uglyNum = new boolean[100000];
        uglyNum[1] = true;
        int i = 0, num = 0;
        while (i < n) {
            if (isUgly(num, uglyNum)) {
                i++;
                uglyNum[num] = true;
            }
            num++;
        }
        return num - 1;
    }

    public boolean isUgly(int num, boolean[] uglyNum) {
        if (num <= 0) return false;
        if (num % 2 == 0) num /= 2;
        else if (num % 3 == 0) num /= 3;
        else if (num % 5 == 0) num /= 5;
        return uglyNum[num];
    }

    //dp
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[t2] * 2, dp[t3] * 3), dp[t5] * 5);

            if (dp[i] == dp[t2] * 2)
                t2++;
            if (dp[i] == dp[t3] * 3)
                t3++;
            if (dp[i] == dp[t5] * 5)
                t5++;
        }
        return dp[n - 1];
    }
}