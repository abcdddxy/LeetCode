import java.util.HashMap;
import java.util.Map;

public class offer34_FirstNotRepeatChar {
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
