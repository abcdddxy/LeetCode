import java.util.Arrays;
import java.util.Stack;

public class lee32_LongValParent_hard {
    //栈
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int maxLen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') stack.push(i);
            if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else maxLen = Math.max(maxLen, i - stack.peek());
            }
        }
        return maxLen;
    }

    //dp
    public int longestValidParentheses2(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        int maxLen = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        System.out.println("dp = [" + Arrays.toString(dp) + "]");
        return maxLen;
    }

    //左右扫描
    public int longestValidParentheses3(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int maxLen = 0, left = 0, right = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') left++;
            else right++;

            if (left == right) maxLen = Math.max(maxLen, left + right);
            else if (right > left) left = right = 0;
        }
        left = right = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++;
            else right++;

            if (left == right) maxLen = Math.max(maxLen, left + right);
            else if (right > left) left = right = 0;
        }

        return maxLen;
    }
}
