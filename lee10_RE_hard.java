public class lee10_RE_hard {
    public boolean isMatch(String s, String p) {
        for (int i = 0; i < s.length() && i < p.length() && s.charAt(s.length() - 1) == p.charAt(p.length() - 1); i++) {
            s = s.substring(0, s.length() - 1);
            p = p.substring(0, p.length() - 1);
        }
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        if (s.isEmpty()) {
            for (int i = 0; i < p.length() && p.charAt(p.length() - 1) == '*'; i++) {
                p = p.substring(0, p.length() - 2);
            }
            return p.isEmpty();
        }
        if (p.equals(".*")) {
            return true;
        }
        if (p.length() != s.length() && !p.contains("*")) {
            return false;
        }

        int ss, sp;
        char preChr = ' ';
        System.out.println("s = [" + s + "], p = [" + p + "]");

        for (ss = 0, sp = 0; ss < s.length() && sp < p.length(); ) {
            switch (p.charAt(sp)) {
                case '.':
                    preChr = p.charAt(sp);
                    sp++;
                    ss++;
                    break;
                case '*':
                    if (preChr == ' ') {
                        return false;
                    } else if (preChr == '.') {
                        ss++;
                    } else {
                        if (preChr == s.charAt(ss)) {
                            ss++;
                        } else {
                            if (sp == p.length() - 1) {
                                return false;
                            }
                            sp++;
                        }
                    }
                    break;
                default:
                    preChr = p.charAt(sp);
                    if (preChr == s.charAt(ss)) {
                        ss++;
                        sp++;
                        System.out.println("ss = [" + ss + "], sp = [" + sp + "]");
                    } else {
                        sp++;
                    }
                    break;
            }
        }
        for (int i = 0; i < p.length() && p.charAt(p.length() - 1) == '*'; i++) {
            p = p.substring(0, p.length() - 2);
        }
        return ss >= s.length() - 1 && sp >= p.length() - 1;
    }

    public boolean isMatch2(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        } else if (p.length() == 1) {
            return s.length() == 1 && isEqual(s, p);
        } else if (p.charAt(1) != '*') {
            return s.length() > 0 && isEqual(s, p) && isMatch(s.substring(1), p.substring(1));
        } else {
            if (s.length() > 0 && isEqual(s, p)) {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2));
            }
        }
    }

    public boolean isEqual(String s, String p) {
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }
}
