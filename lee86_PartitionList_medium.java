public class lee86_PartitionList_medium {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode left = new ListNode(0), right = new ListNode(0);
        ListNode leftPreHead = null, rightPreHead = null;
        ListNode leftHead = left, rightHead = right;
        while (head != null) {
            System.out.println(head.val);
            if (head.val < x) {
                left.val = head.val;
                left.next = new ListNode(0);
                leftPreHead = left;
                left = left.next;
            } else {
                right.val = head.val;
                right.next = new ListNode(0);
                rightPreHead = right;
                right = right.next;
            }
            head = head.next;
        }
        if (leftPreHead != null) leftPreHead.next = null;
        if (rightPreHead != null) rightPreHead.next = null;
        if (leftPreHead != null && rightPreHead != null) leftPreHead.next = rightHead;
        return leftPreHead == null ? rightHead : leftHead;
    }
}
