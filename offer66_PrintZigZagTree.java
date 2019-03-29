import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class offer66_PrintZigZagTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    // 使用Pair
    private ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) return ans;
        ArrayList<Integer> tmp = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(pRoot, 0));
        boolean flag = true;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            tmp.add(pair.getKey().val);
            if (pair.getKey().left != null) queue.offer(new Pair<>(pair.getKey().left, pair.getValue() + 1));
            if (pair.getKey().right != null) queue.offer(new Pair<>(pair.getKey().right, pair.getValue() + 1));
            if (!queue.peek().getValue().equals(pair.getValue())) {
                addTreeNode(tmp, flag);
                tmp.clear();
                flag = !flag;
            }
        }
        return ans;
    }

    private void addTreeNode(ArrayList<Integer> list, boolean flag) {
        if (flag) {
            ans.add(list);
        } else {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = list.size() - 1; i >= 0; i++) tmp.add(list.get(i));
            ans.add(tmp);
        }
    }

    // 递归
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        if (pRoot == null) return ans;
        zigzagTreeNode(pRoot, 0, true);
        return ans;
    }

    private void zigzagTreeNode(TreeNode t, int level, boolean flag) {
        if (t == null) return;
        if (ans.size() <= level) ans.add(new ArrayList<>());
        if (flag) ans.get(level).add(t.val);
        else ans.get(level).add(0, t.val);
        zigzagTreeNode(t.left, level + 1, !flag);
        zigzagTreeNode(t.right, level + 1, !flag);
    }
}
