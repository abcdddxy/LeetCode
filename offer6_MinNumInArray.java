public class offer6_MinNumInArray {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        if (array[0] == 1) return 1;
        int low = 0, high = array.length - 1, mid;
        while (low < high) {
            if (array[low] < array[high]) return array[low];
            mid = (low + high) / 2;
            if (array[low] < array[mid]) low = mid + 1;
            else if(array[mid] == array[low]) low += 1;
            else  high = mid;
        }
        return array[low];
    }
}
