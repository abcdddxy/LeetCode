public class offer61_IsNumeric {
    private boolean dotFlag = false;
    private boolean eFlag = false;
    private boolean ans = true;

    public boolean isNumeric(char[] str) {
        if (str.length == 0) return false;
        if (str[0] == '-' || str[0] == '+') check(str, 1);
        else check(str, 0);
        return ans;
    }

    private void check(char[] str, int order) {
        if (order == str.length) return;
        char c = str[order];
        if (c >= '0' && c <= '9') check(str, order + 1);
        else if (c == '.') {
            if (dotFlag) ans = false;
            else {
                dotFlag = true;
                check(str, order + 1);
            }
        } else if (c == 'e' || c == 'E') {
            if (eFlag) ans = false;
            else {
                eFlag = true;
                dotFlag = true;
                if (order == str.length - 1) {
                    ans = false;
                    return;
                }
                if (str[order + 1] == '-' || str[order + 1] == '+') check(str, order + 2);
                else check(str, order + 1);
            }
        } else ans = false;
    }
}
