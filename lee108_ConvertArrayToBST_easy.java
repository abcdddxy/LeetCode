import java.util.Arrays;

public class lee108_ConvertArrayToBST_easy {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        System.out.println("nums = [" + Arrays.toString(nums) + "]");
        if (nums.length == 0) return null;
        int len = nums.length;
        TreeNode ans = new TreeNode(nums[len / 2]);
        ans.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, len / 2));
        ans.right = sortedArrayToBST(Arrays.copyOfRange(nums, len / 2 + 1, len));
        return ans;
    }
}
