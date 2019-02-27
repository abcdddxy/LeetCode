public class lee117_PopNextRighyPointers_medium {
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

    // 和上一题一样的代码
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

    //更快的做法
}
