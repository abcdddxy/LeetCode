import java.util.ArrayList;

public class offer24_FindPath {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return ans;
        dfs(root, target, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(TreeNode t, int target, int curr, ArrayList<Integer> tmp) {
        tmp.add(t.val);
        if (t.left == null && t.right == null && curr + t.val == target) {
            ans.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }
        if (curr > target) return;
        if (t.left != null) dfs(t.left, target, curr + t.val, tmp);
        if (t.right != null) dfs(t.right, target, curr + t.val, tmp);
        tmp.remove(tmp.size() - 1);
    }
}
