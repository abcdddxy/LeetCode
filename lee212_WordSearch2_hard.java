import java.util.LinkedList;
import java.util.List;

public class lee212_WordSearch2_hard {
    // 完全在WordSearch基础上
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();

        for (String word : words) {
            if (exist(board, word) && !res.contains(word)) res.add(word);
        }
        return res;
    }

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

        System.out.println("board = [" + board[i][j] + "]");
        board[i][j] ^= '#';
        System.out.println("board = [" + board[i][j] + "]");
        boolean flag = search(board, i - 1, j, word, chNum + 1) ||
                search(board, i, j - 1, word, chNum + 1) ||
                search(board, i + 1, j, word, chNum + 1) ||
                search(board, i, j + 1, word, chNum + 1);
        board[i][j] ^= '#';

        return flag;
    }

    //快速方法，Trie树（前缀树）
    class Node {
        String word;
        Node[] next = new Node[26];
    }

    public Node bulidTrie(String[] words) {
        Node node = new Node();
        for (String word : words) {
            Node p = node;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new Node();
                p = p.next[i];
            }
            p.word = word;
        }
        return node;
    }

    public List<String> findWords2(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        Node node = bulidTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search2(board, i, j, node, res);
            }
        }
        return res;
    }

    public void search2(char[][] board, int i, int j, Node node, List<String> res) {
        char ch = board[i][j];
        if (ch == '#' || node.next[ch - 'a'] == null) return;
        node = node.next[ch - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        if (i > 0) search2(board, i - 1, j, node, res);
        if (j > 0) search2(board, i, j - 1, node, res);
        if (i < board.length - 1) search2(board, i + 1, j, node, res);
        if (j < board[0].length - 1) search2(board, i, j + 1, node, res);
        board[i][j] = ch;
    }
}
