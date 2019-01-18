import java.util.Arrays;

public class lee303_RangeSumQuery_easy {

    private int[] sum;

    public lee303_RangeSumQuery_easy(int[] nums) {
        sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) sum[i] = nums[0];
            else sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? sum[j] : sum[j] - sum[i - 1];
    }
}
