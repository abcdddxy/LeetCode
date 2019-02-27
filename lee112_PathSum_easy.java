public class lee112_PathSum_easy {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean ans = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        pathSum(0, root, sum);
        return ans;
    }

    private void pathSum(int curr, TreeNode t, int sum) {
        System.out.println("curr = [" + curr + "], t = [" + t.val + "]");
        if (t.left == null && t.right == null && curr + t.val == sum) {
            ans = true;
            return;
        }
        if (t.left != null) pathSum(curr + t.val, t.left, sum);
        if (t.right != null) pathSum(curr + t.val, t.right, sum);
    }
}
