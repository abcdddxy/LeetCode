public class lee142_LinkedListCycle2_medium {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode tor = head, hare = head;
        while (hare != null && hare.next != null) {
            tor = tor.next;
            hare = hare.next.next;
            if (tor == hare) break;
        }
        if (tor != hare) return null;
        if (hare == head) return head;
        ListNode node1 = head, node2 = hare;
        while (true) {
            node1 = node1.next;
            node2 = node2.next;
            if (node1 == node2) break;
        }
        return node1;
    }
}
