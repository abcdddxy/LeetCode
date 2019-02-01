public class lee338_CountBits_medium {
    //暴力搜索
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = numOfOne(i);
        }
        return res;
    }

    private int numOfOne(int num) {
        int res = 0;
        while (num >= 1) {
            if (num % 2 == 1) res += 1;
            num /= 2;
        }
        return res;
    }

    //dp
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        int idx = 1;
        for (int i = 0; i <= num; i++) {
            if(i == idx * 2) idx *= 2;
            res[i] = res[i - idx] + 1;
        }
        return res;
    }
}
