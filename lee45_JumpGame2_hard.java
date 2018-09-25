public class lee45_JumpGame2_hard {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] count = new int[len];
        for (int i = 0; i < len; i++) {
            count[i] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < nums[i] && j < len - i - 1; j++) {
                count[i + j] = Math.min(count[i + j], count[i] + 1);
            }
        }
        return count[len - 1];
    }

    public int jump2(int[] nums) {
        int jumplength = 0, jump = 0, maxjump = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i < jumplength){
                jump ++;
                jumplength = maxjump;
            }

            maxjump = Math.max(maxjump, i+nums[i]);
        }
        return jump;
    }
}
