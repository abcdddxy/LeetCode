import java.util.Stack;

public class lee114_FlattenBTToList_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        System.out.println("prev = [" + (prev == null ? null : prev.val) + "], root = [" + root.val + "]");
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
