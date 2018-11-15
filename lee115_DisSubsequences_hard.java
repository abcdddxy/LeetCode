public class lee115_DisSubsequences_hard {
    public int numDistinct(String s, String t) {
        int len1 = t.length(), len2 = s.length();
        if (len1 == 0 || len2 == 0) return 0;
        int[][] dp = new int[len1][len2];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (i == 0 && j == 0) dp[i][j] = (t.charAt(i) == s.charAt(j)) ? 1 : 0;
                else if (i == 0) dp[i][j] = (t.charAt(i) == s.charAt(j)) ? dp[i][j - 1] + 1 : dp[i][j - 1];
                else if (j < i) dp[i][j] = 0;
                else dp[i][j] = (t.charAt(i) == s.charAt(j)) ? dp[i][j - 1] + dp[i - 1][j - 1] : dp[i][j - 1];
            }
        }

        return dp[len1 - 1][len2 - 1];
    }
}
