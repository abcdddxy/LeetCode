public class lee84_LargeRect_hard {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int h : heights) {
            int area = getRect(heights, h);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public int getRect(int[] heights, int h) {
        int maxLen = 0, len = 0;
        for (int i : heights) {
            if (i >= h) {
                len++;
                maxLen = Math.max(maxLen, len);
            } else len = 0;
        }
        return h * maxLen;
    }

    //dfs
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int maxArea = 0, area;
        for (int i = 0; i < n; i++) {
            area = dfsGetRect(heights, n, i);
            System.out.println("area = [" + area + "]");
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public int dfsGetRect(int[] heights, int n, int i) {
        int left = i - 1, right = i + 1;
        while (left >= 0 && heights[left] >= heights[i]) left--;
        while (right < n && heights[right] >= heights[i]) right++;
        return heights[i] * (right - left - 1);
    }

    //dp，关键是tmp值的改变
    public int largestRectangleArea3(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp] >= heights[i])
                tmp = left[tmp] - 1;
            left[i] = tmp + 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < n && heights[tmp] >= heights[i])
                tmp = right[tmp] + 1;
            right[i] = tmp - 1;
        }
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] + 1));
        }
        return maxArea;
    }
}
