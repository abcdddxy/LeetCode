public class lee21_MergeTwoLists_easy {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        for (; l1 != null && l2 != null; ) {
            if (l1.val < l2.val) {
                res.val = l1.val;
                res.next = new ListNode(0);
                res = res.next;
                l1 = l1.next;
            } else {
                res.val = l2.val;
                res.next = new ListNode(0);
                res = res.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            res.val = l2.val;
            res.next = l2.next;
        } else if (l2 == null) {
            res.val = l1.val;
            res.next = l1.next;
        }
        return head;
    }
}
