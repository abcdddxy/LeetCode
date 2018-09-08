public class lee5_LongestPalindromic_medium {

    //动态规划
    public String longestPalindrome(String s) {
        int maxLen = 1;
        int maxIdx = 0;
        boolean[][] flag = new boolean[s.length()][s.length()];

        if (s.length() == 0) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || flag[j + 1][i - 1])) {
                    flag[j][i] = true;

                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        maxIdx = j;
                    }
                }
            }
        }
        return s.substring(maxIdx, maxIdx + maxLen);
    }

    //双向生长判定
    private int start, end, maxLen;

    public void isPal(String str, int i, int j) {
        while (str.charAt(i) == str.charAt(j) && i > 0 && j < str.length() - 1) {
            i--;
            j++;
        }
        if (str.charAt(i) == str.charAt(j) && j - i + 1 > maxLen) {
            start = i;
            end = j;
            maxLen = j - i + 1;
        } else if(str.charAt(i) != str.charAt(j) && j - i - 1 > maxLen){
            start = i + 1;
            end = j - 1;
            maxLen = j - i - 1;
        }

    }

    public String longestPalindrome2(String s) {

        if (s.length() == 0) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            isPal(s, i, i);
            isPal(s, i, i + 1);
        }
        System.out.println("start = [" + start + "] end = [" + end + "]");
        return s.substring(start, end + 1);
    }
}
