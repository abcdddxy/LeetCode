public class offer59_FirstAppearingOnce {
    private int[] chars = new int[256];
    private int index = 1;

    public void Insert(char ch) {
        if (chars[ch] == 0) chars[ch] = index++;
        else chars[ch] = -1;
    }

    public char FirstAppearingOnce() {
        int min = Integer.MAX_VALUE;
        char ans = '#';
        for (int i = 0; i < 256; i++) {
            if (chars[i] > 0 && chars[i] < min) {
                min = chars[i];
                ans = (char) i;
            }
        }
        return ans;
    }
}
