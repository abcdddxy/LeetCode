import java.util.LinkedList;
import java.util.List;

public class lee173_BSTIterator_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> ans = new LinkedList<>();

    public int BSTIterator(TreeNode root) {
        if (root == null) return 0;
        preTravel(ans, root);
        return 1;
    }

    private void preTravel(List<Integer> l, TreeNode t) {
        if (t.left != null) preTravel(l, t.left);
        l.add(t.val);
        if (t.right != null) preTravel(l, t.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return ans.remove(0);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return ans.size() != 0;
    }
}
