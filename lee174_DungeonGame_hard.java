import java.util.Arrays;

public class lee174_DungeonGame_hard {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int h = dungeon.length, w = dungeon[0].length;
        int[][] dp = new int[h][w];
        int res = 0;

        //倒序dp
        for (int i = h - 1; i >= 0; i--) {
            for (int j = w - 1; j >= 0; j--) {
                if (i == h - 1 && j == w - 1) dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                else if (i == h - 1) dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                else if (j == w - 1) dp[i][j] = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                else dp[i][j] = Math.min(Math.max(dp[i + 1][j] - dungeon[i][j], 1), Math.max(dp[i][j + 1] - dungeon[i][j], 1));
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }
}
