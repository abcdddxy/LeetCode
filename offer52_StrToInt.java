public class offer52_StrToInt {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        boolean isNeg = str.charAt(0) == '-';
        if (str.charAt(0) == '+' || str.charAt(0) == '-') str = str.substring(1);
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') ans = ans * 10 + (c - '0');
            else return 0;
        }
        return isNeg ? -ans : ans;
    }
}
