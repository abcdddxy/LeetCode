import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lee18_4sum_medium {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        if (len < 4) {
            return res;
        }
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int start = j + 1, end = len - 1; start < end; ) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    System.out.println("i = [" + i + "], j = [" + j + "], start = [" + start + "], end = [" + end + "]");
                    if (sum < target) {
                        start++;
                    } else if (sum > target) {
                        end--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        for (start++, end--; start < end && nums[start] == nums[start - 1] && nums[end] == nums[end + 1]; start++);
                    }
                }
            }
        }
        return res;
    }
}
