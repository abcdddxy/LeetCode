import java.util.Arrays;

public class lee167_TwoSum2_easy {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = {0, 0};
        for (int i = 0; i < numbers.length; i++) {
            int tmp = binarySearch(numbers, target - numbers[i]);
            System.out.println("tmp = [" + tmp + "]");
            if (tmp != -1 && tmp != numbers[i]) {
                ans[0] = i + 1;
                ans[1] = tmp + 1;
                break;
            }
        }
        Arrays.sort(ans);
        return ans;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid;
        }
        return -1;
    }
}
