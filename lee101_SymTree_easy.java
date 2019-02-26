public class lee101_SymTree_easy {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        TreeNode left = root.left, right = root.right;
        return isSym(left, right);
    }

    private boolean isSym(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val != r.val) return false;
        if ((l.left == null && r.right == null && l.right == null && r.left == null)
                || (l.left == null && r.right == null && l.right == r.left)
                || (l.left == r.right && l.right == null && r.left == null)
                || (l.left == r.right && l.right == r.left)) return true;
        System.out.println("l = [" + l.val + "], r = [" + r.val + "]");
        return isSym(l.right, r.left) && isSym(l.left, r.right);
    }
}
