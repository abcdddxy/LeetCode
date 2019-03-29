import java.util.Stack;

public class offer21_IsStack {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);
        int order1 = 1, order2 = 0;
        while (!stack.isEmpty()) {
            if (popA[order2] == stack.peek()) {
                stack.pop();
                order2++;
            } else {
                if (order1 >= pushA.length) break;
                stack.push(pushA[order1]);
                order1++;
            }
        }
        return stack.isEmpty();
    }
}
