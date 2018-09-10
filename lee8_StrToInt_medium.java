public class lee8_StrToInt_medium {
    public int myAtoi(String str) {
        String symbol = "-+";
        String num = "0123456789";

        int i;
        int start = -1, end = -1;
        boolean isFirstNum = false;
        boolean isNeg = false;
        double s;

        if (str.length() == 0) {
            return 0;
        }

        loop:
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && !isFirstNum) {

            } else if (symbol.contains(String.valueOf(str.charAt(i))) || num.contains(String.valueOf(str.charAt(i)))) {
                System.out.println("str = [" + str.charAt(i) + "]");
                if (str.charAt(i) == '-' && !isFirstNum) {
                    isNeg = true;
                }

                if (!isFirstNum) {
                    if (num.contains(String.valueOf(str.charAt(i)))) {
                        start = i;
                        end = i;
                        System.out.println("start = [" + start + "], end = [" + end + "], i = [" + i + "]");
                    }
                    isFirstNum = true;
                } else if (num.contains(String.valueOf(str.charAt(i)))) {
                    if (start == -1 && end == -1) {
                        start = i;
                        end = i;
                    } else {
                        end++;
                    }
                    System.out.println("start = [" + start + "], end = [" + end + "], i = [" + i + "]");
                } else {
                    break loop;
                }
            } else {
                break loop;
            }
        }
        if (isFirstNum) {
            if (start == -1 && end == -1) {
                return 0;
            } else {
                s = isNeg ? -Double.parseDouble(str.substring(start, end + 1)) : Double.parseDouble(str.substring(start, end + 1));
                if (s > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (s < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else {
                    return (int) s;
                }
            }
        } else {
            return 0;
        }
    }

    //简便方法
    public int myAtoi2(String str) {
        long s = 0;
        int isNeg = 1;

        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        switch (str.charAt(0)) {
            case '-':
                isNeg = -1;
            case '+':
                str = str.substring(1);
                break;
        }

        for (char ch : str.toCharArray()) {
            if (ch <= '9' && ch >= '0') {
                s = 10 * s + ch - '0';
                if (s * isNeg > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (s * isNeg < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        return (int) s * isNeg;
    }
}
