import java.util.*;

public class lee49_GroupAnagrams_medium {
    //纯map操作，超时
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new LinkedList<>();
        List<Map<Character, Integer>> mapList = new LinkedList<>();
        if (strs.length == 0) return ans;
        for (String str : strs) {
            Map<Character, Integer> tmp = new HashMap<>();
            for (Character c : str.toCharArray()) {
                if (!tmp.containsKey(c)) tmp.put(c, 1);
                else tmp.put(c, tmp.get(c) + 1);
            }
            System.out.println(tmp.toString());
            if (ans.size() == 0) {
                List<String> tmpL = new LinkedList<>();
                tmpL.add(str);
                ans.add(tmpL);
                mapList.add(tmp);
            } else {
                boolean isContain = false;
                for (int i = 0; i < mapList.size(); i++) {
                    if (mapIsEqual(mapList.get(i), tmp)) {
                        ans.get(i).add(str);
                        isContain = true;
                    }
                }
                if (!isContain) {
                    List<String> tmpL = new LinkedList<>();
                    tmpL.add(str);
                    ans.add(tmpL);
                    mapList.add(tmp);
                }
            }
        }
        return ans;
    }
    private boolean mapIsEqual(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        if (m1.isEmpty() && m2.isEmpty()) return true;
        if (m1.isEmpty() || m2.isEmpty()) return false;
        for (Character c : m1.keySet()) {
            if (!(m2.containsKey(c) && m2.get(c).equals(m1.get(c)))) return false;
        }
        for (Character c : m2.keySet()) {
            if (!(m1.containsKey(c) && m1.get(c).equals(m2.get(c)))) return false;
        }
        return true;
    }

    //带有排序的map操作
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }

    //计数查找
    public List<List<String>> groupAnagrams3(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}
