import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class lee301_RemoveInvalidParent_hard {
    private Set<String> set = new HashSet<>();
    private List<String> ans = new LinkedList<>();

    public List<String> removeInvalidParentheses(String s) {
        removeRight(s);
        return ans;
    }

    private void removeRight(String s) {
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') match++;
            else if (s.charAt(i) == ')') match--;
            if (match < 0) {
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(j) != ')') continue;
                    String newS = s.substring(0, j) + s.substring(j + 1);
                    if (!set.add(newS)) continue;
                    removeRight(newS);
                }
                return;
            }
        }
        if (match == 0) {
            ans.add(s);
            return;
        }
        removeLeft(s);
    }

    private void removeLeft(String s) {
        int match = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') match++;
            else if (s.charAt(i) == '(') match--;
            if (match < 0) {
                for (int j = s.length() - 1; j >= i; j--) {
                    if (s.charAt(j) != '(') continue;
                    String newS = s.substring(0, j) + s.substring(j + 1);
                    if (!set.add(newS)) continue;
                    removeLeft(newS);
                }
                return;
            }
        }
        ans.add(s);
    }
}
