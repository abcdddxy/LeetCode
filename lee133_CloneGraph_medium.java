import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class lee133_CloneGraph_medium {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node head = new Node();
        if(map.containsKey(node.val)) return map.get(node.val);
        head.val = node.val;
        map.put(head.val, head);
        head.neighbors = new LinkedList<>();
        for (Node n : node.neighbors) head.neighbors.add(cloneGraph(n));
        return head;
    }
}
