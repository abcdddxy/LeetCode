import java.util.HashMap;
import java.util.Map;

public class lee61_RotateList_medium {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0) return head;
        ListNode ans = head;
        int count = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (head != null) {
            map.put(count, head);
            count++;
            head = head.next;
        }
        System.out.println(map.toString() + count);
        if (k % count == 0 || count == 1) return ans;
        if (k > count) k = k % count;
        ans = map.get(count - k);
        if (count > 1) {
            map.get(count - 1).next = map.get(0);
            map.get(count - k - 1).next = null;
        }
        return ans;
    }
}
