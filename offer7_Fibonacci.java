public class offer7_Fibonacci {
    public int Fibonacci(int n) {
        if (n <= 1) return n;
        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) ans[i] = ans[i - 2] + ans[i - 1];
        return ans[n];
    }
}
