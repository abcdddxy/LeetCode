import java.util.Stack;

public class offer36_FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode ans = null;
        ListNode tmp1 = null, tmp2 = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ans = tmp1;
            tmp1 = stack1.pop();
            tmp2 = stack2.pop();
            if (tmp1 != tmp2) return ans;
        }
        ans = tmp1;
        return ans;
    }
}
