public class lee104_MaxDepthOfBT_easy {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int ans = 1;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        DFS(root, 1);
        return ans;
    }

    private void DFS(TreeNode t, int count) {
        if (count > ans) ans = count;
        if (t.left != null) DFS(t.left, count + 1);
        if (t.right != null) DFS(t.right, count + 1);
    }
}
