import javafx.util.Pair;

import java.util.*;

public class lee127_wordLadder_medium {
    // dfs, 超时
    int ans = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> init = new LinkedList<>();
        init.add(beginWord);
        dfs(beginWord, endWord, wordList, init);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private void dfs(String begin, String end, List<String> wordList, List<String> curr) {
        if (begin.equals(end)) {
            ans = Math.min(ans, curr.size());
            return;
        }
        if (wordList.size() == 0) return;
        for (String word : wordList) {
            if (distance(begin, word) == 1) {
                List<String> tmp1 = new LinkedList<>(wordList);
                List<String> tmp2 = new LinkedList<>(curr);
                tmp1.remove(word);
                tmp2.add(begin);
                dfs(word, end, tmp1, tmp2);
            }
        }
    }

    private int distance(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count;
    }

    // bfs，使用词典存储编辑距离为1的单词，使用Pair存储当前单词数
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (String word : wordList) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                if (!map.containsKey(newWord)) map.put(newWord, new LinkedList<>());
                map.get(newWord).add(word);
            }
        }
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            Pair<String, Integer> tmp = queue.poll();
            String word = tmp.getKey();
            int count = tmp.getValue();
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                for (String str : map.getOrDefault(newWord, new LinkedList<>())) {
                    if (str.equals(endWord)) return count + 1;
                    if (visited.add(str)) queue.offer(new Pair<>(str, count + 1));
                }
            }
        }
        return 0;
    }
}
