public class offer65_IsSymmetrical {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return check(pRoot.left, pRoot.right);
    }

    private boolean check(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && check(t1.left, t2.right) && check(t1.right, t2.left);
    }
}
