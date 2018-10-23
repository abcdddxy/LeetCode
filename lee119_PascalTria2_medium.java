import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lee119_PascalTria2_medium {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new LinkedList<>();
        if (rowIndex == 0) return Arrays.asList(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> current = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 | j == i) current.add(1);
                else current.add(ans.get(j - 1) + ans.get(j));
            }
            ans = current;
        }
        return ans;
    }
}
