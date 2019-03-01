import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class lee144_BTPreTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        preTravel(ans, root);
        return ans;
    }

    private void preTravel(List<Integer> l, TreeNode t) {
        l.add(t.val);
        if (t.left != null) preTravel(l, t.left);
        if (t.right != null) preTravel(l, t.right);
    }

    // 非递归
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                ans.add(p.val);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
        return ans;
    }
}
