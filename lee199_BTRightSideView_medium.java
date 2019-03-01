import java.util.*;

public class lee199_BTRightSideView_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // BFS搜索每层最右边节点
    public class LevelTree {
        TreeNode tree;
        int level;

        LevelTree(TreeNode _tree, int _level) {
            tree = _tree;
            level = _level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<LevelTree> q = new LinkedList<>();
        q.offer(new LevelTree(root, 0));
        while (!q.isEmpty()) {
            LevelTree tmp = q.poll();
            if (q.isEmpty() || tmp.level < q.peek().level) ans.add(tmp.tree.val);
            if (tmp.tree.left != null) q.offer(new LevelTree(tmp.tree.left, tmp.level + 1));
            if (tmp.tree.right != null) q.offer(new LevelTree(tmp.tree.right, tmp.level + 1));
        }
        return ans;
    }

    // DFS搜索
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Map<Integer, Integer> map = new HashMap<>();
        int maxDepth = -1;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                maxDepth = Math.max(depth, maxDepth);
                if (!map.containsKey(depth)) map.put(depth, node.val);
                nodeStack.push(node.left);
                depthStack.push(depth + 1);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
            }
            System.out.println("map = [" + map.toString() + "], node = [" + node.val + "]");
        }
        for (int depth = 0; depth <= maxDepth; depth++) {
            ans.add(map.get(depth));
        }
        return ans;
    }
}
