public class lee198_HouseRobber_easy {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int rob = 0, noRob = 0;

        for (int n : nums) {
            int tmp = rob;
            rob = Math.max(rob, noRob + n);
            noRob = tmp;
        }

        return rob;
    }
}
