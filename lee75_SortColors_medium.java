import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lee75_SortColors_medium {
    // 偷懒
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    // 暴力解法
    public void sortColors2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) map.put(i, 0);
            map.put(i, map.get(i) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(0) && map.get(0) > 0) {
                nums[i] = 0;
                map.put(0, map.get(0) - 1);
            } else if (map.containsKey(1) && map.get(1) > 0) {
                nums[i] = 1;
                map.put(1, map.get(1) - 1);
            } else nums[i] = 2;
        }
    }

    // 双指针
    public void sortColors3(int[] nums) {
        int left = 0, right = nums.length - 1, order = 0;
        while (order <= right) {
            if (nums[order] == 0) {
                nums[order] = nums[left];
                nums[left] = 0;
                left++;
            } else if (nums[order] == 2) {
                nums[order] = nums[right];
                nums[right] = 2;
                right--;
                order--;
            }
            order++;
            System.out.println(Arrays.toString(nums));
        }
    }
}
