public class lee50_SolvePow_medium {
    // 暴力解
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long nn = n;
        if (n < 0) {
            nn = -nn;
            x = (double) 1 / x;
        }
        double ans = 1;
        for (int i = 0; i < nn; i++) ans *= x;
        return ans;
    }

    // 二分查找
    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        long nn = n;
        if (n < 0) {
            nn = -nn;
            x = (double) 1 / x;
        }
        return pow(x, nn);
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;
        double ans = pow(x, n / 2);
        if (n % 2 == 0) return ans * ans;
        else return ans * ans * x;
    }
}
