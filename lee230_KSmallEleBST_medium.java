import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lee230_KSmallEleBST_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 中序遍历得到数组
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans = new LinkedList<>();
        preTravel(root, ans);
        System.out.println(ans.toString());
        return ans.get(k - 1);
    }

    private void preTravel(TreeNode t, List<Integer> ans) {
        if (t.left != null) preTravel(t.left, ans);
        ans.add(t.val);
        if (t.right != null) preTravel(t.right, ans);
    }

    // 中序遍历直接返回
    private int ans;
    private int count;

    public int kthSmallest2(TreeNode root, int k) {
        preTravel(root, k);
        return ans;
    }

    private void preTravel(TreeNode t, int k) {
        if (t.left != null) preTravel(t.left, k);
        count ++;
        if(count == k){
            ans = t.val;
            return;
        }
        if (t.right != null) preTravel(t.right, k);
    }
}
