import java.util.Comparator;
import java.util.PriorityQueue;

public class offer60_GetMidFromStream {
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        if (count % 2 == 0) minHeap.offer(num);
        else maxHeap.offer(num);
        if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
            int tmp = minHeap.poll();
            minHeap.offer(maxHeap.poll());
            maxHeap.offer(tmp);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 1) return (double) minHeap.peek();
        else return (double) (minHeap.peek() + maxHeap.peek()) / 2;
    }
}
