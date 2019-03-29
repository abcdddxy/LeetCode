public class offer28_MoreThanHalf {
    public int MoreThanHalfNum_Solution2(int[] array) {
        if (array.length == 0) return 0;
        int count = 1, pre = array[0];
        if (array.length == 1) return array[0];
        for (int i = 1; i < array.length; i++) {
            if (pre == array[i]) count++;
            else count--;
            if (count == 0) {
                pre = array[i];
                count = 1;
            }
        }
        return checkMoreThanHalf(array, pre) ? pre : 0;
    }

    private boolean checkMoreThanHalf(int[] array, int ans) {
        int count = 0;
        for (int i : array) {
            if (i == ans) count++;
        }
        return count > array.length / 2;
    }
}
