public class lee437_PathSum3_easy {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return ans;
        pathSum(0, root, sum);
        return ans;
    }

    private void pathSum(int curr, TreeNode t, int sum) {
        System.out.println("curr = [" + curr + "], t = [" + t.val + "]");
        if (curr + t.val == sum || t.val == sum) ans += 1;
        if (t.left == null && t.right == null) return;
        if (t.left != null) {
            pathSum(curr + t.val, t.left, sum);
            if (t.val == 0 || curr != 0) pathSum(t.val, t.left, sum);
        }
        if (t.right != null) {
            pathSum(curr + t.val, t.right, sum);
            if (t.val == 0 || curr != 0) pathSum(t.val, t.right, sum);
        }
    }
}
