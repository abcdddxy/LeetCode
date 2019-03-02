import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class lee138_CopyListRandomPointer_medium {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Node> ansMap = new HashMap<>();
        Node ans = new Node();
        Node headAns = ans;
        Node p = head;
        while (p.next != null) {
            map.put(p.val, p.random == null ? null : p.random.val);
            ans.val = p.val;
            p = p.next;
            ansMap.put(ans.val, ans);
            ans.next = new Node();
            ans = ans.next;
        }
        ans.val = p.val;
        ansMap.put(ans.val, ans);
        map.put(p.val, p.random == null ? null : p.random.val);

        for (Node n : ansMap.values()) n.random = ansMap.get(map.get(n.val));

        return headAns;
    }
}
