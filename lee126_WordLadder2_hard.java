import java.util.*;

public class lee126_WordLadder2_hard {
    // 果然超时了
    int minLen = Integer.MAX_VALUE;
    List<List<String>> ans = new LinkedList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        int len = beginWord.length();
        for (int i = 0; i < len; i++) {
            for (String word : wordList) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                if (!map.containsKey(newWord)) map.put(newWord, new LinkedList<>());
                map.get(newWord).add(word);
            }
        }
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        dfs(beginWord, endWord, new LinkedList<>(), map, len, visited);
        return ans;
    }
    private void dfs(String begin, String end, List<String> curr, Map<String, List<String>> map, int len, Set<String> visited) {
        if (curr.size() >= minLen) return;
        if (begin.equals(end)) {
            curr.add(end);
            if (curr.size() < minLen) {
                minLen = Math.min(minLen, curr.size());
                ans.clear();
                ans.add(curr);
            } else if (curr.size() == minLen) ans.add(curr);
            return;
        }
        for (int i = 0; i < len; i++) {
            String newWord = begin.substring(0, i) + "*" + begin.substring(i + 1, len);
            Set<String> newVisited = new HashSet<>(visited);
            for (String word : map.getOrDefault(newWord, new LinkedList<>())) {
                if (newVisited.add(word)) {
                    List<String> tmp = new LinkedList<>(curr);
                    tmp.add(begin);
                    dfs(word, end, tmp, map, len, newVisited);
                }
            }
        }
    }

    // 大改进，先用bfs求最小间隔，再用dfs求解
    public List<List<String>> findLadders2(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        ArrayList<String> solution = new ArrayList<>();
        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, nodeNeighbors, distance, solution, res);
        return res;
    }
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict) nodeNeighbors.put(str, new ArrayList<>());
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);
                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor)) foundEnd = true;
                        else queue.offer(neighbor);
                    }
                }
            }
            if (foundEnd) break;
        }
    }
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char chs[] = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) res.add(String.valueOf(chs));
                chs[i] = old_ch;
            }
        }
        return res;
    }
    private void dfs(String cur, String end, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }
}
