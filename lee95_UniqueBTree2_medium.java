import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class lee95_UniqueBTree2_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return Collections.EMPTY_LIST;
        }
        return bulidTree(0, n);
    }

    public List<TreeNode> bulidTree(int left, int right) {
        List<TreeNode> ans = new LinkedList<>();
        List<TreeNode> leftList = new LinkedList<>(), rightList = new LinkedList<>();
        if (left > right) {
            ans.add(null);
            return ans;
        }

        for (int i = left; i <= right; i++) {
            leftList = bulidTree(left, i - 1);
            rightList = bulidTree(i + 1, right);

            for (TreeNode hleft : leftList) {
                for (TreeNode hright : rightList) {
                    TreeNode h = new TreeNode(i);
                    h.left = hleft;
                    h.right = hright;
                    ans.add(h);
                }
            }
        }
        return ans;
    }

    //DP
    public List<TreeNode> generateTrees1(int n) {
        if (n < 1) {
            return Collections.EMPTY_LIST;
        }

        List<TreeNode>[] map = new LinkedList[n + 1];
        map[0] = new LinkedList<>();
        map[0].add(null);

        for (int i = 1; i <= n; i++) {
            map[i] = new LinkedList<>();

            for (int j = 1; j <= i; j++) {
                for (TreeNode left : map[j - 1]) {
                    for (TreeNode right : map[i - j]) {
                        TreeNode h = new TreeNode(j);
                        h.left = left;
                        h.right = offsetClone(right, j);
                        map[i].add(h);
                    }
                }
            }

        }
        return map[n];
    }

    public TreeNode offsetClone(TreeNode t, int offset){
        TreeNode h = new TreeNode(t.val + offset);
        h.left = offsetClone(t.left, offset);
        h.right = offsetClone(t.right, offset);
        return h;
    }
}
