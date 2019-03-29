public class offer56_NDice {
    public void numberOfDice(int n) {
        for (int i = n; i <= 6 * n; i++) {
            System.out.println(CountNumber(n, i));
        }
    }

    private int CountNumber(int n, int s) {
        if (s < n || s > 6 * n) return 0;
        if (n == 1) return 1;
        else return CountNumber(n - 1, s - 6) + CountNumber(n - 1, s - 5) + CountNumber(n - 1, s - 4) +
                CountNumber(n - 1, s - 3) + CountNumber(n - 1, s - 2) + CountNumber(n - 1, s - 1);
    }
}
