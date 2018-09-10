public class lee7_RevInt_easy {
    public int reverse(int x) {
        boolean flag = true;
        boolean is_nag = false;
        long rev = 0;

        if (x < 0) {
            is_nag = true;
            x = -x;
        }

        if (x < 10 && x > -10) {
            return x;
        }

        String str = String.valueOf(x);

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != '0' || !flag) {
                rev = rev * 10 + Integer.parseInt(String.valueOf(str.charAt(i)));
                flag = false;
            }
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }
        return is_nag ? -(int)rev : (int)rev;
    }
}
