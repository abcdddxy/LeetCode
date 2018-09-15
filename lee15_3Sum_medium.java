import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class lee15_3Sum_medium {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sum = new LinkedList<>();
        List tmp_list;
        int tmp, order;
        if (nums.length < 3) {
            return Arrays.asList();
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ) {
            for (int j = i + 1; j < nums.length; ) {
                tmp = -(nums[i] + nums[j]);
                tmp_list = Arrays.stream(nums).boxed().collect(Collectors.toList());

                if (tmp_list.contains(tmp)) {
                    order = tmp_list.lastIndexOf(tmp);
                    if (order >= 0 && order != i && order != j && !hasList(sum, nums[i], nums[j], (int) tmp_list.get(order))) {
                        sum.add(Arrays.asList(nums[i], nums[j], nums[order]));
                    }
                }
                j += jump(nums, j);
            }
            i += jump(nums, i);
        }
        return sum;
    }

    public boolean hasList(List<List<Integer>> sum, int a, int b, int c) {
        return sum.contains(Arrays.asList(a, b, c)) || sum.contains(Arrays.asList(a, c, b))
                || sum.contains(Arrays.asList(b, a, c)) || sum.contains(Arrays.asList(b, c, a))
                || sum.contains(Arrays.asList(c, b, a)) || sum.contains(Arrays.asList(c, a, b));
    }

    public int jump(int[] nums, int start) {
        int jump = 1;
        for (; start + jump < nums.length - 1 && nums[start + jump] == nums[start]; jump++) {
        }
        System.out.println("jump = [" + jump + "]");
        return jump;
    }

    //快速做法，去重与排序后双向寻找
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> sum = new LinkedList<>();
        int tmp;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1, k = nums.length; j < k; ) {
                tmp = nums[i] + nums[j] + nums[k];
                if (tmp < 0) {
                    j++;
                } else if (tmp > 0) {
                    k--;
                } else {
                    sum.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    for (j++, k--; j < k && nums[j] == nums[j - 1]; j++) ;
                }
            }
        }
        return sum;
    }
}
