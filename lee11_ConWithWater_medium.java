public class lee11_ConWithWater_medium {
    public int maxArea(int[] height) {
        int tmpWater, maxWater = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                tmpWater = Math.min(height[i], height[j]) * (j - i);
                maxWater = Math.max(tmpWater, maxWater);
            }
        }
        return maxWater;
    }

    //O(n)推进左右索引
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;
        for (; right > left; ) {
            maxWater = Math.max(Math.min(height[left], height[right]) * (right - left), maxWater);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
