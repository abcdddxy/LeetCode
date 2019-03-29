import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class offer22_BTTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            ArrayList<Integer> ans = new ArrayList<>();
            if(root == null) return ans;
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                ans.add(tmp.val);
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            return ans;
        }
    }
}
