import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class lee145_BTPostTraversal_hard {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        preTravel(ans, root);
        return ans;
    }
    private void preTravel(List<Integer> l, TreeNode t) {
        if (t.left != null) preTravel(l, t.left);
        if (t.right != null) preTravel(l, t.right);
        l.add(t.val);
    }

    //非递归
    public class TagNode {
        TreeNode tree;
        char tag;

        TagNode(TreeNode _tree, char _tag) {
            tree = _tree;
            tag = _tag;
        }
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        TagNode t;
        TreeNode p = root;
        Stack<TagNode> s = new Stack<>();
        while (p != null || !s.isEmpty()) {
            while (p != null) {
                t = new TagNode(p, 'L');
                s.push(t);
                p = p.left;
            }
            if (!s.isEmpty()) {
                t = s.peek();
                t.tag = 'R';
                p = t.tree;
                p = p.right;
            }
            while (!s.isEmpty() && s.peek().tag == 'R') {
                t = s.pop();
                ans.add(t.tree.val);
            }
        }
        return ans;
    }
}
