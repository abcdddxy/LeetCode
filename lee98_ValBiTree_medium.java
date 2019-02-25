import java.util.Stack;

public class lee98_ValBiTree_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 递归
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isBST(root, null, null);
    }

    private boolean isBST(TreeNode t, Integer low_limit, Integer high_limit) {
        if (low_limit != null && t.val <= low_limit) return false;
        if (high_limit != null && t.val >= high_limit) return false;
        return (t.left == null || isBST(t.left, low_limit, t.val)) && (t.right == null || isBST(t.right, t.val, high_limit));
    }

    // DFS
    public boolean isValidBST2(TreeNode root) {
        double limit = Double.MIN_VALUE;
        Stack<TreeNode> s = new Stack<>();

        while (!s.isEmpty() || root != null) {
            System.out.println("limit = [" + limit + "]");
            if (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (root.val <= limit) return false;
            limit = root.val;
            root = root.right;
        }
        return true;
    }
}