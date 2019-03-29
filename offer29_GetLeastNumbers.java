import java.util.ArrayList;
import java.util.PriorityQueue;

public class offer29_GetLeastNumbers {
    // 快排
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (k == input.length) {
            for (int i = 0; i < input.length; i++) ans.add(input[i]);
            return ans;
        }
        if (k > input.length || k <= 0) return ans;
        int low = 0, high = input.length - 1;
        int p = partition(input, low, high);
        while (p != k - 1) {
            if (p > k - 1) high = p - 1;
            else low = p + 1;
            p = partition(input, low, high);
        }
        for (int i = 0; i < k; i++) ans.add(input[i]);
        return ans;
    }

    private int partition(int[] nums, int low, int high) {
        int p = nums[low];
        int i = low, j = high + 1;
        while (true) {
            while (nums[++i] < p) {
                if (i == high) break;
            }
            while (nums[--j] > p) {
                if (j == low) break;
            }
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, j, low);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 堆排序
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (k == input.length) {
            for (int i = 0; i < input.length; i++) ans.add(input[i]);
            return ans;
        }
        if (k > input.length || k <= 0) return ans;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) priorityQueue.offer(input[i]);
        for (int i = 0; i < k; i++) ans.add(priorityQueue.poll());
        return ans;
    }
}
