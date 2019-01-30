import java.util.Arrays;

public class lee321_CteateMaxNumber_hard {
    // 理解错题意了
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

    //dp
    public int[] maxNumber2(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }
    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }
}
