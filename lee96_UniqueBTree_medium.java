import java.util.Arrays;

public class lee96_UniqueBTree_medium {
    public int numTrees(int n) {
        if (n < 3) return n;
        int[] ans = new int[n + 1];
        ans[1] = 1;
        ans[2] = 2;

        for (int i = 3; i <= n; i++) {
            int tmp = 0;
            for (int j = 0; j < i / 2; j++) {
                if (j < 2) tmp += 2 * ans[i - j - 1];
                else tmp += 2 * ans[j] * ans[i - j - 1];
            }
            if (i % 2 == 1) tmp += ans[i / 2] * ans[i / 2];
            ans[i] = tmp;
        }
        System.out.println("ans = " + Arrays.toString(ans));

        return ans[n];
    }
}
