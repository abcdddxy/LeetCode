import java.util.Arrays;
import java.util.Comparator;

public class offer32_PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        if (numbers.length == 0) return "";
        if (numbers.length == 1) return String.valueOf(numbers[0]);
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) strs[i] = String.valueOf(numbers[i]);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return a.compareTo(b);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) sb.append(strs[i]);
        return sb.toString();
    }
}
