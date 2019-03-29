import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class offer45_IsContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) return false;
        if (numbers.length == 1) return true;
        Arrays.sort(numbers);
        int count = 0, gap = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                if (!set.add(numbers[i])) return false;
            }
            if (numbers[i] == 0) count++;
            else if (i != 0 && numbers[i - 1] != 0) gap += numbers[i] - numbers[i - 1] - 1;
        }
        return count >= gap;
    }
}
