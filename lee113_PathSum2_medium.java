import java.util.ArrayList;
import java.util.List;

public class lee113_PathSum2_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return ans;
        pathSum(0, new ArrayList<>(), root, sum);
        return ans;
    }

    private void pathSum(int curr, List<Integer> l, TreeNode t, int sum) {
        l.add(t.val);
        if (t.left == null && t.right == null && curr + t.val == sum) {
            ans.add(new ArrayList(l));
            l.remove(l.size() - 1);
            return;
        }
        if (t.left != null) pathSum(curr + t.val, l, t.left, sum);
        if (t.right != null) pathSum(curr + t.val, l, t.right, sum);
        l.remove(l.size() - 1);
    }
}
