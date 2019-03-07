public class lee69_SolveSqrt_easy {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 0, right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("mid = [" + mid + "]");
            if (mid * mid == x) return mid;
            if (mid * mid < x) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}
