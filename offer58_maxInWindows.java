import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class offer58_maxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (num.length == 0) return ans;
        if (num.length < size || size < 1) return ans;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            while (!deque.isEmpty() && num[i] > num[deque.peekLast()]) deque.removeLast();
            deque.offerLast(i);
        }
        for (int i = size - 1; i < num.length; i++) {
            while (!deque.isEmpty() && num[i] > num[deque.peekLast()]) deque.removeLast();
            deque.offerLast(i);
            if(i - deque.peekFirst() + 1 > size) deque.removeFirst();
            ans.add(num[deque.peekFirst()]);
        }
        return ans;
    }
}
