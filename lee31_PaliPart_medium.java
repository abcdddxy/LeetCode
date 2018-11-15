import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class lee31_PaliPart_medium {
    //递归
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        int len = s.length();
        if (len == 0) return ans;
        dfs(s, ans, new LinkedList<>(), 0);
        return ans;
    }

    public void dfs(String s, List<List<String>> ans, List<String> tmp, int i) {
        if (i == s.length()) {
            ans.add(new LinkedList<>(tmp));
            return;
        } else {
            for (int len = 1; len <= s.length() - i; len++) {
                if (isPali(s.substring(i, i + len))) {
                    tmp.add(s.substring(i, i + len));
                    dfs(s, ans, tmp, i + len);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
        System.out.println("ans = " + ans.toString());
    }

    public boolean isPali(String s) {
        int len = s.length();
        if (len == 1) return true;
        else if (len == 2) return s.charAt(0) == s.charAt(1);
        else {
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - 1 - i)) return false;
            }
            return true;
        }
    }

    //2D dp
    public List<List<String>> partition2(String s) {
        int len = s.length();
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
                    for (List<String> st : ans[j]) {
                        List<String> tmp = new LinkedList<>(st);
                        System.out.println("tmp = [" + tmp + "]");
                        tmp.add(s.substring(j, i + 1));
                        ans[i + 1].add(tmp);
                    }
                }
            }
        }
        return ans[len];
    }
}
