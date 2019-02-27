public class lee110_BalancedBT_easy {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) return -1;
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
