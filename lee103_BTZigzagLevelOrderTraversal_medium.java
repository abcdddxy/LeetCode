import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class lee103_BTZigzagLevelOrderTraversal_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 按顺序返回后倒置列表
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        levelOrd(ans, root, 0);
        for (int i = 0; i < ans.size(); i++) {
            if (i % 2 == 1) reverseList(ans.get(i));
        }
        return ans;
    }

    private void levelOrd(List<List<Integer>> ans, TreeNode t, int count) {
        if (t == null) return;
        if (ans.size() <= count) ans.add(new LinkedList<>());
        ans.get(count).add(t.val);
        levelOrd(ans, t.left, count + 1);
        levelOrd(ans, t.right, count + 1);
    }

    private void reverseList(List<Integer> l) {
        int len = l.size();
        for (int i = 0; i < len / 2; i++) {
            int tmp1 = l.get(i), tmp2 = l.get(len - i - 1);
            l.remove(i);
            l.add(i, tmp2);
            l.remove(len - i - 1);
            l.add(len - i - 1, tmp1);
        }
        System.out.println(l.toString());
    }

    // zigzag遍历
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        zigzagLevelOrd(ans, root, 0, true);
        return ans;
    }

    private void zigzagLevelOrd(List<List<Integer>> ans, TreeNode t, int count, boolean direct) {
        if (t == null) return;
        if (ans.size() <= count) ans.add(new LinkedList<>());
        if (direct) {
            ans.get(count).add(t.val);
        } else {
            ans.get(count).add(0, t.val); // 倒序添加
        }
        zigzagLevelOrd(ans, t.left, count + 1, !direct);
        zigzagLevelOrd(ans, t.right, count + 1, !direct);
    }
}
