public class offer16_MergeList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 循环
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        ListNode ans = new ListNode(0);
        ListNode head = ans, pre = ans;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    ans.val = list1.val;
                    list1 = list1.next;
                } else {
                    ans.val = list2.val;
                    list2 = list2.next;
                }
            } else if (list1 == null) {
                ans.val = list2.val;
                list2 = list2.next;
            } else {
                ans.val = list1.val;
                list1 = list1.next;
            }
            ans.next = new ListNode(0);
            pre = ans;
            ans = ans.next;
        }
        pre.next = null;
        return head;
    }

    // 递归
    public ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode ans = new ListNode(0);
        if (list1.val < list2.val) {
            ans.val = list1.val;
            list1 = list1.next;
        } else {
            ans.val = list2.val;
            list2 = list2.next;
        }
        ans.next = Merge(list1, list2);
        return ans;
    }
}
