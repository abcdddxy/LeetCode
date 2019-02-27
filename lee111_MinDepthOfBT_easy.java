public class lee111_MinDepthOfBT_easy {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int ans = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        DFS(root, 1);
        return ans;
    }

    private void DFS(TreeNode t, int count) {
        if (t.left == null && t.right == null && count < ans) ans = count;
        if (t.left != null) DFS(t.left, count + 1);
        if (t.right != null) DFS(t.right, count + 1);
    }
}
