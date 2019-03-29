import java.util.ArrayList;

public class offer67_PrintLevelTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) return ans;
        levelTreeNode(pRoot, 0);
        return ans;
    }

    private void levelTreeNode(TreeNode t, int level) {
        if (t == null) return;
        if (ans.size() <= level) ans.add(new ArrayList<>());
        ans.get(level).add(t.val);
        levelTreeNode(t.left, level + 1);
        levelTreeNode(t.right, level + 1);
    }
}
