public class lee124_BTMaxPathSum_hard {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        DFS(root);
        return ans;
    }

    private int DFS(TreeNode t) {
        if (t == null) return 0;
        int tLeft = Math.max(0, DFS(t.left));
        int tRight = Math.max(0, DFS(t.right));
        ans = Math.max(ans, tLeft + tRight + t.val);
        return Math.max(tLeft, tRight) + t.val;
    }
}
