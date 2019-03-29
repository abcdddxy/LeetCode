import java.util.ArrayList;
import java.util.Stack;

public class offer3_PrintArrayList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 栈
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) ans.add(stack.pop());
        return ans;
    }

    // 反转链表
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (listNode == null) return ans;
        ListNode preNode = null, nextNode = listNode;
        while (listNode != null && listNode.next != null) {
            if (preNode == null) {
                preNode = listNode;
                listNode = listNode.next;
            } else {
                nextNode = listNode.next;
                listNode.next = preNode;
                preNode = listNode;
                listNode = nextNode;
            }
        }
        nextNode.next = listNode;
        while (nextNode != null) {
            ans.add(nextNode.val);
            nextNode = nextNode.next;
        }
        return ans;
    }
}
