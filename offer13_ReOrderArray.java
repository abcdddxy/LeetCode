import java.util.LinkedList;
import java.util.List;

public class offer13_ReOrderArray {
    // 双链表
    public void reOrderArray(int[] array) {
        List<Integer> list1 = new LinkedList<>(), list2 = new LinkedList<>();
        for (int i : array) {
            if (i % 2 == 1) list1.add(i);
            else list2.add(i);
        }
        for (int i = 0; i < array.length; i++) {
            if (i < list1.size()) array[i] = list1.get(i);
            else array[i] = list2.get(i - list1.size());
        }
    }

    // 双指针
    public void reOrderArray2(int[] array) {
        int i = -1, j = array.length;
        while (true) {
            while (array[++i] % 2 == 1) {
                if (i == array.length - 1) break;
            }
            while (array[--j] % 2 == 0) {
                if (j == 0) break;
            }
            if (i >= j) break;
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
}
