public class lee66_PlusOne_easy {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len - 1] != 9) {
            digits[len - 1]++;
            return digits;
        } else {
            for (int i = len - 1; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                    if (i == 0) {
                        int[] res = new int[len + 1];
                        res[0] = 1;
                        for (int j = 0; j < len; j++) res[j + 1] = digits[j];
                        return res;
                    }
                } else {
                    digits[i]++;
                    return digits;
                }
            }
        }
        return digits;
    }
}
