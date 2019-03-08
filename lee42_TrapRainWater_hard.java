import java.util.Arrays;
import java.util.Stack;

public class lee42_TrapRainWater_hard {
    // 暴力搜索
    public int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) maxLeft = Math.max(maxLeft, height[j]);
            for (int j = i; j < height.length; j++) maxRight = Math.max(maxRight, height[j]);
            ans += Math.min(maxLeft, maxRight) - height[i];
            System.out.println("i = [" + i + "], ans = [" + ans + "]");
        }
        return ans;
    }

    // dp
    public int trap2(int[] height) {
        int ans = 0;
        int[] dp = new int[height.length];
        int maxLeft = 0, maxRight = 0;
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            dp[i] = Math.max(dp[i], maxLeft - height[i]);
        }
        for (int i = height.length - 2; i >= 1; i--) {
            maxRight = Math.max(maxRight, height[i]);
            dp[i] = Math.min(dp[i], maxRight - height[i]);
        }
        System.out.println(Arrays.toString(dp));
        for (int i : dp) ans += i;
        return ans;
    }

    // stack
    public int trap3(int[] height) {
        int ans = 0, order = 0;
        Stack<Integer> stack = new Stack<>();
        while (order < height.length) {
            while (!stack.isEmpty() && height[order] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int dis = order - stack.peek() - 1;
                ans += dis * (Math.min(height[order], height[stack.peek()]) - height[top]);
                System.out.println("ans = [" + ans + "], order = [" + order + "]");
            }
            stack.push(order);
            order++;
        }
        return ans;
    }

    // 双指针
    public int trap4(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else ans += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
