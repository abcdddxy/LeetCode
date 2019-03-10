import java.util.Arrays;

public class lee135_Candy_hard {
    // 两个列表
    public int candy(int[] ratings) {
        int ans = 0;
        int preRate = ratings[0], preCandy = 1;
        int[] left = new int[ratings.length], right = new int[ratings.length];
        left[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > preRate) {
                preCandy += 1;
                left[i] = preCandy;
            } else {
                preCandy = 1;
                left[i] = preCandy;
            }
            preRate = ratings[i];
        }
        preRate = ratings[ratings.length - 1];
        preCandy = 1;
        right[ratings.length - 1] = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > preRate) {
                preCandy += 1;
                right[i] = preCandy;
            } else {
                preCandy = 1;
                right[i] = preCandy;
            }
            preRate = ratings[i];
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for (int i = 0; i < ratings.length; i++) ans += Math.max(left[i], right[i]);
        return ans;
    }

    // 贪心算法
    public int candy2(int[] ratings) {
        if (ratings.length <= 1) return ratings.length;
        int candies = 0;
        int up = 0;
        int down = 0;
        int old_slope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int new_slope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
            if ((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (new_slope > 0) up++;
            if (new_slope < 0) down++;
            if (new_slope == 0) candies++;
            old_slope = new_slope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }

    private int count(int n) {
        return (n * (n + 1)) / 2;
    }
}
