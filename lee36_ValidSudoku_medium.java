import java.util.HashMap;
import java.util.Map;

public class lee36_ValidSudoku_medium {
    public boolean isValidSudoku(char[][] board) {
        int len = 9, tableLen = 3;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.clear();
            for (int j = 0; j < len; j++) {
                if (board[i][j] != '.') {
                    if (!map.containsKey(board[i][j] - '0')) map.put(board[i][j] - '0', 1);
                    else return false;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            map.clear();
            for (int j = 0; j < len; j++) {
                if (board[j][i] != '.') {
                    if (!map.containsKey(board[j][i] - '0')) map.put(board[j][i] - '0', 1);
                    else return false;
                }
            }
        }
        for (int order = 0; order < 9; order++) {
            map.clear();
            for (int i = 0; i < tableLen; i++) {
                for (int j = 0; j < tableLen; j++) {
                    if (board[(order / 3) * 3 + i][(order % 3) * 3 + j] != '.') {
                        if (!map.containsKey(board[(order / 3) * 3 + i][(order % 3) * 3 + j] - '0'))
                            map.put(board[(order / 3) * 3 + i][(order % 3) * 3 + j] - '0', 1);
                        else return false;
                    }
                }
            }
        }
        return true;
    }
}