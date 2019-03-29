import java.util.Arrays;

public class offer33_GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) return 0;
        int[] uglyNum = new int[index];
        int a = 0, b = 0, c = 0;
        uglyNum[0] = 1;
        for (int i = 1; i < index; i++) {
            uglyNum[i] = Math.min(uglyNum[a] * 2, Math.min(uglyNum[b] * 3, uglyNum[c] * 5));
            if (uglyNum[i] == uglyNum[a] * 2) a++;
            if (uglyNum[i] == uglyNum[b] * 3) b++;
            if (uglyNum[i] == uglyNum[c] * 5) c++;
        }
        System.out.println(Arrays.toString(uglyNum));
        return uglyNum[index - 1];
    }
}
