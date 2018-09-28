import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lee78_Subsets_medium {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        if (nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        subsets(nums, 0, res, new LinkedList<Integer>());
        return res;
    }

    private void subsets(int[] nums, int start, List<List<Integer>> res, List<Integer> path) {
        System.out.println("start = [" + start + "], res = " + res + ", path = " + path);
        res.add(new LinkedList<Integer>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            subsets(nums, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }
}
