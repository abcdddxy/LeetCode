import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lee118_PascalTria_easy {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        if(numRows == 0) return ans;
        ans.add(Arrays.asList(1));
        if(numRows == 1) return ans;
        ans.add(Arrays.asList(1, 1));
        for (int i = 2; i < numRows; i++) {
            List<Integer> current = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 | j == i) current.add(1);
                else current.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            ans.add(current);
        }
        return ans;
    }
}
