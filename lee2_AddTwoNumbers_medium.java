public class lee2_AddTwoNumbers_medium {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode h = new ListNode(0);
        h.next = ans;
        int flag = 0;
        while ((l1.next != null) && (l2.next != null)) {
            ans.val = (l1.val + l2.val) % 10 + flag;
            if (l1.val + l2.val >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }
            ans.next = new ListNode(0);
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ans.val = (l1.val + l2.val) % 10 + flag;
        if (l1.val + l2.val >= 10) {
            flag = 1;
            if ((l1.next == null) && (l2.next == null)) {
                ans.next = new ListNode(1);
                return h.next;
            }
        } else {
            flag = 0;
            if ((l1.next == null) && (l2.next == null)) {
                return h.next;
            }
        }
        ans.next = new ListNode(0);
        if (l1.next == null) {
            ans.next = l2.next;
            ans.next.val += flag;
        } else {
            ans.next = l1.next;
            ans.next.val += flag;
        }
        return h.next;
    }
}
