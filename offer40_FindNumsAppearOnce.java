import java.util.Arrays;

public class offer40_FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int tmp = 0;
        for (int i : array) tmp ^= i;
        int flag = 1;
        while ((flag & tmp) == 0) flag <<= 1;
        for (int i : array) {
            if ((flag & i) == 0) num1[0] ^= i;
            else num2[0] ^= i;
        }
    }
}
