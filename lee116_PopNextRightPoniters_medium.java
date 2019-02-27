import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lee116_PopNextRightPoniters_medium {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // 层次遍历二叉树
    class nodeLevel {
        public Node node;
        public int level;

        public nodeLevel(Node _node, int _level) {
            node = _node;
            level = _level;
        }
    }
    private List<nodeLevel> l = new LinkedList<>();
    public Node connect(Node root) {
        if (root == null) return null;
        BFS(root);
        for (int i = 0; i < l.size() - 1; i++) {
            System.out.println(l.get(i).node.val);
            if (l.get(i).level < l.get(i + 1).level) l.get(i).node.next = null;
            else l.get(i).node.next = l.get(i + 1).node;
        }
        l.get(l.size() - 1).node.next = null;
        return root;
    }
    private void BFS(Node root) {
        if (root == null) return;
        Queue<nodeLevel> bfs = new LinkedList<>();
        bfs.add(new nodeLevel(root, 0));
        while (!bfs.isEmpty()) {
            nodeLevel tmp = bfs.poll();
            l.add(tmp);
            if (tmp.node.left != null) bfs.add(new nodeLevel(tmp.node.left, tmp.level + 1));
            if (tmp.node.right != null) bfs.add(new nodeLevel(tmp.node.right, tmp.level + 1));
        }
    }

    // 两次层次遍历
    public Node connect2(Node root) {
        if (root == null) return null;
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node(0, null, null, null);
            Node prev = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    prev.next = cur.left;
                    prev = prev.next;
                }
                if (cur.right != null) {
                    prev.next = cur.right;
                    prev = prev.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }
}