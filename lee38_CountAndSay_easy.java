import java.util.Arrays;

public class lee38_CountAndSay_easy {
    public String countAndSay(int n) {
        String[] ans = new String[30];
        ans[0] = "1";
        for (int i = 1; i < n; i++) {
            int tmp = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < ans[i - 1].length(); j++) {
                if (j != ans[i - 1].length() - 1 && ans[i - 1].charAt(j) == ans[i - 1].charAt(j + 1)) tmp ++;
                else {
                    sb.append(tmp);
                    sb.append(ans[i - 1].charAt(j));
                    tmp = 1;
                }
            }
            ans[i] = sb.toString();
        }
        System.out.println(Arrays.toString(ans));
        return ans[n - 1];
    }
}