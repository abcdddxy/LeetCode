public class lee109_ConvertListToBST_medium {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 双指针找中点，递归
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode mid = findMid(head);
        TreeNode t = new TreeNode(mid.val);
        if (head == mid) return t;
        t.left = sortedListToBST(head);
        t.right = sortedListToBST(mid.next);
        return t;
    }

    private ListNode findMid(ListNode head) {
        ListNode pre = null, fast = head, slow = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) pre.next = null;
        return slow;
    }
}
