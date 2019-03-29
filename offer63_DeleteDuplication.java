public class offer63_DeleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode ans = new ListNode(0), tmp = ans, pre = ans;
        ans.next = pHead;
        while (tmp != null) {
            ListNode p = tmp.next;
            if (p == null) break;
            if (p.val == tmp.val) {
                while (p != null && p.val == tmp.val) p = p.next;
                pre.next = p;
                tmp = p;
            } else {
                pre = tmp;
                tmp = p;
            }
        }
        return ans.next;
    }
}
