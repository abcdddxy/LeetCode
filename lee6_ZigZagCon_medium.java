import java.util.Arrays;

public class lee6_ZigZagCon_medium {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        int no = 0;
        String str = "";
        char[][] ch = new char[numRows][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < numRows; j++) {
                if (i % (numRows - 1) == 0) {
                    ch[j][i] = s.charAt(no);
                    no++;
                } else if (i % (numRows - 1) == 1) {
                    if (j == numRows - 2) {
                        ch[j][i] = s.charAt(no);
                        no++;
                    }
                } else if (i % (numRows - 1) != 0 && j != numRows - 1 && j != numRows - 2) {
                    if (ch[j + 1][i - 1] != '\u0000') {
                        ch[j][i] = s.charAt(no);
                        no++;
                    }
                }
                System.out.println("i = [" + i + "], j = [" + j + "], no = [" + no + "], ch = [" + s.charAt(no) + "]");
                if (no == s.length() - 1) {
                    for (i = 0; i < numRows; i++) {
                        for (j = 0; j < s.length(); j++) {
                            if (ch[i][j] != '\u0000') {
                                str += ch[i][j];
                                System.out.println("str = [" + str + "]");
                            }
                        }
                    }
                    return str;
                }
            }
        }
        return str;
    }

    //每行一个数组
    public String convert2(String s, int numRows) {
        String[] strs = new String[numRows];
        Arrays.fill(strs, "");
        boolean down = true;

        if (numRows == 1) {
            return s;
        }

        for (int i = 0, k = 0; k < s.length(); k++) {
            strs[i] += s.charAt(k);

            if (down) {
                if (i == numRows - 1) {
                    i--;
                    down = false;
                } else {
                    i++;
                }
            } else {
                if (i == 0) {
                    i++;
                    down = true;
                } else {
                    i--;
                }
            }
        }

        StringBuilder strb = new StringBuilder();
        for (String str : strs) {
            strb.append(str);
        }
        return strb.toString();
    }
}
