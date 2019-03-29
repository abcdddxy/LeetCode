import java.util.ArrayList;
import java.util.TreeSet;

public class offer27_Permutation {
    private TreeSet<String> ans = new TreeSet<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) return new ArrayList<>();
        fullArrange(str.toCharArray(), 0);
        return new ArrayList<>(ans);
    }

    private void fullArrange(char[] chars, int order) {
        if (order == chars.length) {
            ans.add(String.valueOf(chars));
            return;
        }
        for (int i = order; i < chars.length; i++) {
            swap(chars, order, i);
            fullArrange(chars, order + 1);
            swap(chars, order, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
