public class offer50_SolveSum {
    private int ans = 0;

    public int Sum_Solution(int n) {
        if (n == 0) return 0;
        ans = Sum_Solution(n - 1) + n;
        return ans;
    }
}
