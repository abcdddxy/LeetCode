import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class lee94_BinaryTreeInoTraversal_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 递归中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        inoTravel(ans, root);
        return ans;
    }

    private void inoTravel(List<Integer> ans, TreeNode t) {
        if (t == null) return;
        inoTravel(ans, t.left);
        ans.add(t.val);
        inoTravel(ans, t.right);
    }

    // stack
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }

    // reshape树
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre;
        while (cur != null) {
            System.out.println(ans.toString());
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null) pre = pre.right;
                pre.right = cur;
                TreeNode tmp = cur; //将cur左子树置为null
                cur = cur.left;
                tmp.left = null;
            }
        }
        return ans;
    }
}
