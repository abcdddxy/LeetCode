public class lee130_SurroundedRegions_medium {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && (board[i][j] == 'O'))
                    check(board, i, j, row, col);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((board[i][j] == 'O')) board[i][j] = 'X';
                else if ((board[i][j] == '?')) board[i][j] = 'O';
            }
        }
    }

    private void check(char[][] board, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col) return;
        System.out.println("board = [" + board[i][j] + "], i = [" + i + "], j = [" + j + "]");
        if (board[i][j] != 'O') return;
        else board[i][j] = '?';
        check(board, i - 1, j, row, col);
        check(board, i + 1, j, row, col);
        check(board, i, j - 1, row, col);
        check(board, i, j + 1, row, col);
    }
}
