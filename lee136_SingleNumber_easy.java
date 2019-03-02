import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lee136_SingleNumber_easy {
    // 哈希表
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) map.put(i, 0);
            map.put(i, map.get(i) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) == 1) return i;
        }
        return 1;
    }

    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) set.add(i);
            else set.remove(i);
        }
        for (int n : set) return n;
        return 0;
    }

    //牛逼闪闪的做法（异或）
    public int singleNumber3(int[] nums) {
        int ans = 0;
        for (int i : nums) ans ^= i;
        return ans;
    }
}
