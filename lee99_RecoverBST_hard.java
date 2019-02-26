import java.util.LinkedList;
import java.util.List;

public class lee99_RecoverBST_hard {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void recoverTree(TreeNode root) {
        List<Integer> ino = new LinkedList<>();
        inoTravel(ino, root, null, false);
        System.out.println("ino = [" + ino.toString() + "]");
    }

    private void inoTravel(List<Integer> ino, TreeNode t, Integer pre, boolean alreadyFind) {
        if (t == null) return;
        System.out.println("t = [" + t.val + "], alreadyFind = [" + alreadyFind + "]");
        inoTravel(ino, t.left, t.val, alreadyFind);
        if (!(pre == null || t.val > pre)) {
            if (!alreadyFind) {
                ino.add(t.val);
                ino.add(pre);
                alreadyFind = true;
            } else {
                ino.remove(0);
                ino.add(t.val);
            }
        }
        inoTravel(ino, t.right, t.val, alreadyFind);
    }
}
