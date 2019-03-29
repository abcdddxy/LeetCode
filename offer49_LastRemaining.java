import java.util.Arrays;

public class offer49_LastRemaining {
    // 模拟求解
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;
        boolean[] chlidren = new boolean[n];
        Arrays.fill(chlidren, false);
        int count = n, ptr = 0, tmp = 0;
        while (count > 1) {
            if (!chlidren[ptr]) tmp++;
            if (tmp == m) {
                chlidren[ptr] = true;
                count--;
                tmp = 0;
            }
            if (ptr == n - 1) ptr = 0;
            else ptr++;
        }
        for (int i = 0; i < n; i++) if (!chlidren[i]) return i;
        return -1;
    }

    // 约瑟夫环路，公式求解
    public int LastRemaining_Solution2(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int ans = 0;
        for (int i = 2; i <= n; i++) ans = (ans + m) % i;
        return ans;
    }
}
