public class lee222_CountCompleteTreeNodes_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int ans = 0;

    public int countNodes(TreeNode root) {
        if (root == null) return ans;
        countCCT(root);
        return ans;
    }

    private void countCCT(TreeNode t) {
        ans += 1;
        if (t.left != null) countNodes(t.left);
        if (t.right != null) countNodes(t.right);
    }
}
