public class offer43_LeftRotateStr {
    public String LeftRotateString(String str, int n) {
        if (str == null) return null;
        if (str.length() <= 1) return str;
        n = n % str.length();
        if (n == 0) return str;
        StringBuilder sb = new StringBuilder(), tmp = new StringBuilder();
        sb.append(str.substring(0, n));
        sb.reverse();
        tmp.append(str.substring(n));
        tmp.reverse();
        sb.append(tmp);
        sb.reverse();
        return sb.toString();
    }
}
