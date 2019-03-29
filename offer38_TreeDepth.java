public class offer38_TreeDepth {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private int depth = 1;

    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 1);
        return depth;
    }

    private void dfs(TreeNode t, int level) {
        depth = Math.max(depth, level);
        if (t.left != null) dfs(t.left, level + 1);
        if (t.right != null) dfs(t.right, level + 1);
    }
}
