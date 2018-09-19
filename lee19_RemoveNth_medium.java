public class lee19_RemoveNth_medium {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head;
        ListNode head_new = head;
        int i;
        for (i = 0; res.next != null; i++) {
            if (i < n) {
                System.out.println("res = [" + res.val + "]");
                res = res.next;
            } else {
                System.out.println("head = [" + head.val + "]");
                head = head.next;
                System.out.println("res = [" + res.val + "]");
                res = res.next;
            }
        }
        if (i < n) {
            head_new = head.next;
        } else {
            head.next = head.next.next;
        }
        return head_new;
    }
}
