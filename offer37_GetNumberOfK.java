public class offer37_GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        int last = getLastNum(array, k, 0, array.length - 1), first = getFirstNum(array, k, 0, array.length - 1);
        return first > -1 && last > -1 ? last - first + 1 : 0;
    }

    private int getFirstNum(int[] array, int k, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if(array[mid] == k){
            if (mid == 0 || array[mid - 1] != k) return mid;
            else return getFirstNum(array, k, low, mid - 1);
        }
        if (array[mid] < k) return getFirstNum(array, k, mid + 1, high);
        else return getFirstNum(array, k, low, mid - 1);
    }

    private int getLastNum(int[] array, int k, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if(array[mid] == k){
            if (mid == array.length - 1 || array[mid + 1] != k) return mid;
            else return getLastNum(array, k, mid + 1, high);
        }
        if (array[mid] < k) return getLastNum(array, k, mid + 1, high);
        else return getLastNum(array, k, low, mid - 1);
    }
}
