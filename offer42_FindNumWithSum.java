import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class offer42_FindNumWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : array) set.add(i);
        for (int i : array) {
            if(set.contains(sum - i)){
                ans.add(i);
                ans.add(sum - i);
                return ans;
            }
        }
        return ans;
    }
}
