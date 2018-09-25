import java.util.Arrays;

public class lee55_JumpGame_medium {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int i = 0;
        System.out.println("len = [" + len + "]");
        for (i = 1; i < len; i++) {
            if (nums[len - i] <= i - 1) {
                canJump(Arrays.copyOfRange(nums, 0, len - i));
            }
        }
        return i >= len;
    }

    //遍历求最长可达
    public boolean canJump2(int[] nums) {
        int i = 0;
        for (int reach = 0; i < nums.length && i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);
        }
        return i == nums.length;
    }
}
