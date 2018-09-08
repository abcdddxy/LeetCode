import java.util.HashSet;
import java.util.Set;

public class lee3_LongestSubstring_medium {

    public boolean isRepeat(String s) {
        if (s.length() == 1) {
                return false;
            }

            String tmp = s;

            Set<Character> chr = new HashSet<Character>();
            for (int i = 0; i < s.length(); i++) {
                chr.add(s.charAt(i));
            }
            if (chr.size() == s.length()) {
                return false;
            }
            return true;
        }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = max; j <= s.length() - i; j++) {
                if (!isRepeat(s.substring(i, i + j))) {
                    max = j;
                }
            }
        }
        return max;
    }

    //数组实现双指针/滑动窗口
    public class LongestSubstringWithoutRepeatingCharacters1 {
        public int lengthOfLongestSubstring(String s) {
            int[] count = new int[256];

            int maxLen = 0;
            for (int i = 0, j = 0; j < s.length(); ) {
                if (count[s.charAt(j)] == 0) {
                    count[s.charAt(j)]++;
                    maxLen = Math.max(maxLen, j - i + 1);
                    j++;
                } else {
                    --count[s.charAt(i++)];
                }
            }
            return maxLen;
        }
    }

    //HashSet实现双指针/滑动窗口
    public class LongestSubstringWithoutRepeatingCharacters2 {
        public int lengthOfLongestSubstring(String s) {
            if ((s.length() == 0) || (s.equals(null))) {
                return 0;
            }

            int max = 1;
            int start = 0;
            int end = 0;
            HashSet<Character> set = new HashSet<Character>();
            for (; end < s.length(); ) {
                if (!set.contains(s.charAt(end))) {
                    set.add(s.charAt(end));
                    end++;
                    max = Math.max(end - start + 1, max);
                } else {
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            return max;
        }
    }
}

