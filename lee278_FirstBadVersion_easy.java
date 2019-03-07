public class lee278_FirstBadVersion_easy {
    private boolean isBadVersion(int version) {
        return version % 2 == 0;
    }

    public int firstBadVersion(int n) {
        int left = 0, right = n - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2; // 超范围
            mid = left + (right - left) / 2; // 这样可以
            System.out.println(mid);
            if (isBadVersion(mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
