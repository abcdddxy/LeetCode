public class lee97_InterString_hard {
    // 暴力搜索，超时
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInter(s1, 0, s2, 0, s3, 0);
    }

    public boolean isInter(String s1, int pointer1, String s2, int pointer2, String s3, int pointer3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len3 != len1 + len2) return false;
        if (pointer1 == len1 && pointer2 == len2 && pointer3 == len3) return true;
        boolean ans = false;

        if (pointer1 < len1 && s1.charAt(pointer1) == s3.charAt(pointer3))
            ans |= isInter(s1, pointer1 + 1, s2, pointer2, s3, pointer3 + 1);
        if (pointer2 < len2 && s2.charAt(pointer2) == s3.charAt(pointer3))
            ans |= isInter(s1, pointer1, s2, pointer2 + 1, s3, pointer3 + 1);

        return ans;
    }

    //2D dp
    public boolean isInterleave2(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len3 != len1 + len2) return false;

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) dp[i][j] = true;
                else if (i == 0) dp[i][j] = dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
                else if (j == 0) dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i - 1));
                else {
                    if (dp[i - 1][j]) dp[i][j] |= (s1.charAt(i - 1) == s3.charAt(i + j - 1));
                    if (dp[i][j - 1]) dp[i][j] |= (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
                if (dp[i][j]) System.out.println("i = [" + i + "], j = [" + j + "]");
            }
        }
        return dp[len1][len2];
    }
}
