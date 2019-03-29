public class offer11_NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0;
        char[] chars = Integer.toBinaryString(n).toCharArray();
        for (char c : chars) {
            if (c == '1') count++;
        }
        return count;
    }
}
