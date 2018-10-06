public class lee79_WordSearch_medium {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board, int i, int j, String word, int chNum) {
        if (chNum == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(chNum)) return false;
        System.out.println("i = [" + i + "], j = [" + j + "], chNum=[" + chNum + "], word = [" + word.charAt(chNum) + "]");

        System.out.println("board1 = [" + board[i][j] + "]");
        board[i][j] ^= '#';
        System.out.println("board2 = [" + board[i][j] + "]");
        boolean flag =  search(board, i - 1, j, word, chNum + 1) ||
                search(board, i, j - 1, word, chNum + 1) ||
                search(board, i + 1, j, word, chNum + 1) ||
                search(board, i, j + 1, word, chNum + 1);
        board[i][j] ^= '#';

        return flag;
    }
}
