import java.util.Arrays;

public class lee41_FirstMiss_hard {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0){
            return 1;
        }
        int len = nums.length;
        int[] tmp = new int[len + 1];
        tmp[0] = 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                continue;
            }
            tmp[nums[i]] = 1;
        }

        for (int i = 0; i < len + 1; i++) {
            if (tmp[i] == 0) return i;
        }
        return len + 1;
    }
}
