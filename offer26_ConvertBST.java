public class offer26_ConvertBST {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private TreeNode head, pre;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return pRootOfTree;
        inoOrder(pRootOfTree);
        return head;
    }

    private void inoOrder(TreeNode t) {
        if (t.left != null) inoOrder(t.left);
        if (pre == null) head = t;
        else {
            pre.right = t;
            t.left = pre;
        }
        pre = t;
        if (t.right != null) inoOrder(t.right);
    }
}
