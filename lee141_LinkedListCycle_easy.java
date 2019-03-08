public class lee141_LinkedListCycle_easy {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode tor = head, hare = head;
        while (hare!=null && hare.next != null) {
            tor = tor.next;
            hare = hare.next.next;
            if (tor == hare) return true;
        }
        return false;
    }
}
