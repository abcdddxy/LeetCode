import java.util.*;

public class lee187_RepeatDNA_medium {
    // 使用List，超时
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new LinkedList<>();
        if (s.length() <= 10) return ans;
        List<String> l = new LinkedList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if(!l.contains(sub)) l.add(sub);
            else if(!ans.contains(sub)) ans.add(sub);
        }
        System.out.println(l.toString());
        return ans;
    }

    // 使用HashSet
    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> ans = new LinkedList<>();
        if (s.length() <= 10) return ans;
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if(!set.add(sub) && !ans.contains(sub)) ans.add(sub);
        }
        return ans;
    }
}
