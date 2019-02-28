public class lee129_SumRootToLeafNum_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return numPath(0, root);
    }

    private int numPath(int num, TreeNode t) {
        if (t.left == null && t.right == null) return num;
        int tLeft = (t.left == null ? 0 : numPath(num * 10 + t.val, t.left));
        int tRight = (t.right == null ? 0 : numPath(num * 10 + t.val, t.right));
        return tLeft + tRight;
    }
}
