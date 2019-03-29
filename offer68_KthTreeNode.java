public class offer68_KthTreeNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private int count = 0;
    private TreeNode ans = null;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) return null;
        inoOrder(pRoot, k);
        return ans;
    }

    private void inoOrder(TreeNode t, int k) {
        if (t.left != null) inoOrder(t.left, k);
        count++;
        if (count == k) ans = t;
        if (t.right != null) inoOrder(t.right, k);
    }
}
