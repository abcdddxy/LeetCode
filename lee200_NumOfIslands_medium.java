public class lee200_NumOfIslands_medium {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    check(grid, i, j, row, col);
                    ans += 1;
                }
            }
        }
        return ans;
    }

    private void check(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col) return;
        System.out.println("grid = [" + grid[i][j] + "], i = [" + i + "], j = [" + j + "]");
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            check(grid, i - 1, j, row, col);
            check(grid, i + 1, j, row, col);
            check(grid, i, j - 1, row, col);
            check(grid, i, j + 1, row, col);
        }
    }
}
