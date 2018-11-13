import java.util.Arrays;

public class lee87_ScrambleString_hard {
    //剪枝：长度相同，字母相同
    public boolean isCan(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < s1.length(); i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }

    //递归判断左右子树能否混淆
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (!isCan(s1, s2)) return false;

        for (int i = 1; i < s1.length(); i++) {
            String s1left = s1.substring(0, i), s1right = s1.substring(i);

            String s2left1 = s2.substring(0, i), s2right1 = s2.substring(i);
            String s2left2 = s2.substring(s2.length() - i), s2right2 = s2.substring(0, s2.length() - i);
            if (isScramble(s1left, s2left1) && isScramble(s1right, s2right1)) return true;
            if (isScramble(s1left, s2left2) && isScramble(s1right, s2right2)) return true;
        }

        return false;
    }
}
