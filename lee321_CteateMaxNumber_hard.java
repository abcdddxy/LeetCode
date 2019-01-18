import java.util.Arrays;

public class lee321_CteateMaxNumber_hard {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] ans = new int[k], digits = new int[10];

        if (k == n + m) {
            for (int i = 0; i < n; i++) ans[i] = nums1[i];
            for (int i = 0; i < m; i++) ans[n + i] = nums2[i];
        } else {
            int tmp = 0, digit = 0;
            for (int i = 0; i < n; i++) digits[nums1[i]] += 1;
            for (int i = 0; i < m; i++) digits[nums2[i]] += 1;

            for (int i = 9; i >= 0 && tmp < k; i--) {
                tmp += digits[i];
                digit = i;
            }
            System.out.println("digits = [" + Arrays.toString(digits) + "], digit = [" + digit + "]");

            tmp = 0;
            for (int i = 0; i < n && tmp < k; i++) {
                if (nums1[i] >= digit) {
                    ans[tmp] = nums1[i];
                    tmp++;
                }
            }
            for (int i = 0; i < m && tmp < k; i++) {
                if (nums2[i] >= digit) {
                    ans[tmp] = nums2[i];
                    tmp++;
                }
            }
        }
        return ans;
    }

    public int[] maxNumber2(int[] nums1, int[] nums2, int k) {
        for (int i = 0; i <= k; i++) {
            int[] sub1 = findKMaxSub(nums1, i), sub2 = findKMaxSub(nums2, k - i);
        }
    }

    public int[] findKMaxSub(int[] nums, int k) {
        if (k == 0 || k > nums.length) return null;
        else if (k == nums.length) return nums;
        else {

        }
    }
}
