public class lee14_LongestComm_easy {
    public String longestCommonPrefix(String[] strs) {
        String str = "";
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        for (int j = 0; j < Math.min(strs[0].length(), strs[1].length()); j++) {
            if (strs[0].charAt(j) == strs[1].charAt(j)) {
                str += strs[0].charAt(j);
            } else {
                break;
            }
        }
        if (str.length() == 0) {
            return "";
        }

        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i + 1].length() == 0) {
                return "";
            } else {
                str = commonPre(str, strs[i], strs[i + 1]);
                if (str.length() == 0) {
                    return str;
                }
            }
        }
        return str;
    }

    public String commonPre(String str, String a, String b) {
        if(str.length() > b.length()){
            str = str.substring(0, b.length());
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != a.charAt(i) || a.charAt(i) != b.charAt(i)) {
                System.out.println("i = [" + i + "], str = [" + str + "], a = [" + a + "], b = [" + b + "]");
                str = str.substring(0, i);
            }
        }
        return str;
    }

    //遍历首个字符串，O(n^2)
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0){
            return "";
        }

        String s = "";
        for (int j = 0; j < strs[0].length(); j++) {
            for (int i = 0; i < strs.length; i++) {
                if(s.length() >= strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)){
                    return s;
                }
            }
            s += strs[0].charAt(j);
        }
        return  s;
    }
}
