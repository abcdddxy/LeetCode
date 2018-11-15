import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class lee132_PaliPart2_hard {
    //想偷懒却超时
    public int minCut(String s) {
        int len = s.length(), minCut = Integer.MAX_VALUE;
        List<List<String>>[] ans = new LinkedList[len + 1];
        boolean[][] dp = new boolean[len][len];
        ans[0] = new LinkedList<>();
        //一定要加上初始化
        ans[0].add(Collections.EMPTY_LIST);
        for (int i = 0; i < len; i++) {
            ans[i + 1] = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j > i - 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    for (int k = 0; k < ans[j].size(); k++) {
                        List<String> tmp = new LinkedList<>(ans[j].get(k));
                        tmp.add(s.substring(j, i + 1));
                        ans[i + 1].add(tmp);
                        if (i == len - 1) minCut = Math.min(minCut, tmp.size());
                    }
                }
            }
        }
        return minCut - 1;
    }

    public int minCut2(String s) {
        int len = s.length();
        int[] cut = new int[len + 1];
        boolean[][] dp = new boolean[len][len];
        cut[0] = len;

        for (int i = 0; i < len; i++) {
            cut[i + 1] = len;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j > i - 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    cut[i + 1] = Math.min(cut[i + 1], cut[j] + 1);
                }
            }
        }
        System.out.println("cut = [" + Arrays.toString(cut) + "]");
        return cut[len];
    }
}
