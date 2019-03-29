public class offer64_GetNextTree {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode ans;
        if (pNode.right != null) {
            ans = pNode.right;
            while (ans.left != null) ans = ans.left;
        } else {
            if (pNode.next != null && pNode.next.left != null && pNode.next.left.val == pNode.val) ans = pNode.next;
            else {
                while (pNode.next != null && pNode.next.right != null && pNode.next.right.val == pNode.val)
                    pNode = pNode.next;
                ans = pNode.next;
            }
        }
        return ans;
    }
}
