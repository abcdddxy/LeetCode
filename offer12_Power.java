public class offer12_Power {
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        boolean isMinus = exponent < 0;
        exponent = Math.abs(exponent);
        if (exponent % 2 == 1) return isMinus ? 1 / (Power(base, exponent - 1) * base) : Power(base, exponent - 1) * base;
        return isMinus ? 1 / Power(base * base, exponent / 2) : Power(base * base, exponent / 2);
    }
}
