import java.util.HashMap;
import java.util.Map;

public class lee76_MinWinSub_hard {
    // 左右滑动窗口搜索
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        int left = 0, right = 0;
        int[] ans = {-1, 0, 0};
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        Map<Character, Integer> tmp = new HashMap<>();
        int count = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (tmp.containsKey(c)) tmp.put(c, tmp.get(c) + 1);
            else tmp.put(c, 1);
            if (map.containsKey(c) && tmp.get(c).equals(map.get(c))) count++;
            while (left <= right && count == map.size()) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                tmp.put(c, tmp.get(c) - 1);
                if (map.containsKey(c) && tmp.get(c) < map.get(c)) count--;
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
