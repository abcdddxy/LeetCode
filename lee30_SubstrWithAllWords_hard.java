import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class lee30_SubstrWithAllWords_hard {
    // 暴力解，时间超
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0 || words[0].length() == 0) return new LinkedList<>();
        int n = words.length, len = words[0].length();
        if (n * len > s.length()) return new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        List<String> con = new LinkedList<>();
        fullSortConcatenation(con, words, 0, n - 1);
        for (String str : con) {
            for (int tmp : substring(s, str))
                if (tmp != -1 && !ans.contains(tmp)) ans.add(tmp);
        }
        return ans;
    }

    private List<Integer> substring(String haystack, String needle) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == needle.length() - 1) ans.add(i);
            }
        }
        return ans;
    }

    private void fullSortConcatenation(List<String> con, String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        if (start == end) {
            for (String str : words) sb.append(str);
            con.add(sb.toString());
        }
        for (int i = start; i <= end; i++) {
            swap(words, i, start);
            fullSortConcatenation(con, words, start + 1, end);
            swap(words, i, start);
        }
    }

    private static void swap(String[] words, int i, int j) {
        String tmp = words[i];
        words[i] = words[j];
        words[j] = tmp;
    }

    //hash
    public List<Integer> findSubstring3(String s, String[] words) {
        if (words.length == 0 || words[0].length() == 0) return new LinkedList<>();
        int n = words.length, len = words[0].length();
        if (n * len > s.length()) return new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) map.put(word, map.get(word) + 1);
            else map.put(word, 1);
        }
        for (int i = 0; i < s.length() - n * len + 1; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            for (int j = 0; j < n * len; j++) {
                if ((j + 1) % len == 0) {
                    String word = s.substring(i + j - len + 1, i + j + 1);
                    if (map.containsKey(word)) {
                        int num = 0;
                        if (tmp.containsKey(word)) num = tmp.get(word);
                        if (map.get(word) <= num) break;
                        else tmp.put(word, num + 1);
                    } else break;
                }
                if (j == n * len - 1) ans.add(i);
            }
        }
        return ans;
    }
}
