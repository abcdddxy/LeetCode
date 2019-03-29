import java.util.HashSet;
import java.util.Set;

public class offer53_Duplicate {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!set.add(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
