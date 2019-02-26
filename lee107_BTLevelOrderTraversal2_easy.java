import java.util.LinkedList;
import java.util.List;

public class lee107_BTLevelOrderTraversal2_easy {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        levelOrd(ans, root, 0);
        return ans;
    }

    private void levelOrd(List<List<Integer>> ans, TreeNode t, int count) {
        if (t == null) return;
        if (ans.size() <= count) ans.add(0, new LinkedList<>());
        ans.get(ans.size() - count - 1).add(t.val);
        levelOrd(ans, t.left, count + 1);
        levelOrd(ans, t.right, count + 1);
    }
}
