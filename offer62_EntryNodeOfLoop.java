public class offer62_EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode ptr1 = pHead, ptr2 = pHead;
        do {
            if (ptr1 == null || ptr2 == null || ptr2.next == null) return null;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        } while (ptr1 != ptr2);
        ListNode ans = pHead;
        while (ptr2 != ans) {
            ptr2 = ptr2.next;
            ans = ans.next;
        }
        return ans;
    }
}
