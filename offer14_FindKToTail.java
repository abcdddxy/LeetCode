public class offer14_FindKToTail {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode i = head, j = head;
        while (i != null) {
            if (k == 0) j = head;
            k--;
            i = i.next;
            if (k < 0) j = j.next;
        }
        return k > 0 ? null : j;
    }
}
