public class lee330_PatchingArray_hard {
    public int minPatches(int[] nums, int n) {
        if (n <= 0) return 0;
        int ans = 0, curr = 0;
        long miss = 1;
        while (miss <= n) {
            if (curr < nums.length && nums[curr] <= miss) {
                miss += nums[curr];
                curr++;
            } else {
                ans += 1;
                miss += miss;
            }
        }
        return ans;
    }
}
