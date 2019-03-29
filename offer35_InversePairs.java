public class offer35_InversePairs {
    private int count = 0;

    public int InversePairs(int[] array) {
        int[] tmp = new int[array.length];
        sort(array, 0, array.length - 1, tmp);
        return count;
    }

    private void sort(int[] array, int low, int high, int[] tmp) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(array, low, mid, tmp);
            sort(array, mid + 1, high, tmp);
            merge(array, low, mid, high, tmp);
        }
    }

    private void merge(int[] array, int low, int mid, int high, int[] tmp) {
        int i = low, j = mid + 1, t = 0;
        while (i <= mid && j <= high) {
            if (array[i] > array[j]) {
                count = (count + mid - i + 1) % 1000000007;
                tmp[t++] = array[j++];
            } else tmp[t++] = array[i++];
        }
        while (i <= mid) tmp[t++] = array[i++];
        while (j <= high) tmp[t++] = array[j++];
        t = 0;
        while (low <= high) array[low++] = tmp[t++];
    }
}
