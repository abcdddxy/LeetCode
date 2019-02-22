public class lee44_WildMatch_hard {
    // 递归超时
    public boolean isMatch(String s, String p) {
        if (onlyContainAsterisk(p)) return true;
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() == 0 || p.length() == 0) return false;
        System.out.println("s = [" + replaceAsterisk(p) + "]");
        return isWildMatch(s, replaceAsterisk(p));
    }
    private boolean isWildMatch(String s, String p){
        if (onlyContainAsterisk(p)) return true;
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() == 0 || p.length() == 0) return false;

        switch (p.charAt(0)) {
            case '*':
                return isWildMatch(s.substring(1), p) || isWildMatch(s, p.substring(1));
            case '?':
                return isWildMatch(s.substring(1), p.substring(1));
            default:
                return s.charAt(0) == p.charAt(0) && isWildMatch(s.substring(1), p.substring(1));
        }
    }
    private boolean onlyContainAsterisk(String s) {
        if (s.length() == 0) return false;
        for (char c : s.toCharArray())
            if (c != '*') return false;
        return true;
    }
    private String replaceAsterisk(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!(s.charAt(i - 1) == '*' && s.charAt(i) == '*')) sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // 回溯
    public boolean isMatch2(String s, String p) {
        int pp = -1, ss = -1; //回溯点
        int pIdx = 0, sIdx = 0; //指针

        while (sIdx < s.length()) {
            if (pIdx == p.length()) {
                if (pp == -1) return false;
                else {
                    pIdx = pp + 1;
                    sIdx = ss++;
                }
            } else if (p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx)) {
                pIdx++;
                sIdx++;
            } else if (p.charAt(pIdx) == '*') {
                pp = pIdx;
                ss = sIdx;
                pIdx++;
            } else {
                if (pp == -1) return false;
                else {
                    pIdx = pp + 1;
                    sIdx = ss++;
                }
            }
        }
        while (pIdx < p.length()) {
            if (p.charAt(pIdx) != '*') break;
            pIdx++;
        }
        return pIdx == p.length();
    }
}
