import java.util.Arrays;

public class lee72_EditDis_hard {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0 || len2 == 0) return Math.abs(len1 - len2);
        int[][] ans = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            ans[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            ans[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) ans[i][j] = ans[i - 1][j - 1];
                else ans[i][j] = Math.min(Math.min(ans[i - 1][j], ans[i][j - 1]), ans[i - 1][j - 1]) + 1;
            }
        }
        System.out.println("ans = " + Arrays.toString(ans));

        return ans[len1][len2];
    }
}
