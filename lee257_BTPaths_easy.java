import java.util.LinkedList;
import java.util.List;

public class lee257_BTPaths_easy {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<>();
        if (root == null) return ans;
        DFS(ans, new StringBuilder(), root);
        return ans;
    }

    private void DFS(List<String> ans, StringBuilder sb, TreeNode t) {
        if (t.left == null && t.right == null) {
            if (sb.length() == 0) sb.append(t.val);
            else {
                sb.append("->");
                sb.append(t.val);
            }
            ans.add(sb.toString());
            return;
        }
        if (sb.length() == 0) sb.append(t.val);
        else {
            sb.append("->");
            sb.append(t.val);
        }
        if (t.left != null) DFS(ans, new StringBuilder(sb), t.left);
        if (t.right != null) DFS(ans, new StringBuilder(sb), t.right);
    }
}
