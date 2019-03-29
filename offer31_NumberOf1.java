public class offer31_NumberOf1 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) ans += numberOf1(i);
        return ans;
    }

    private int numberOf1(int n) {
        int count = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            if (c == '1') count++;
        }
        return count;
    }
}
