public class lee43_MultiplyStr_medium {
    //投机取巧
    public String multiply(String num1, String num2) {
        long p = Long.valueOf(num1), q = Long.valueOf(num2);
        return String.valueOf(p * q);
    }

    //正常解
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        String result = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int mulplier = num1.charAt(i) - 48;
            if (mulplier == 0) continue;
            StringBuilder cur = new StringBuilder();
            int count = num1.length() - 1 - i;
            for (int k = 0; k < count; k++)
                cur.append(0);
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mulplited = num2.charAt(j) - 48;
                int multiply = mulplited * mulplier + carry;
                cur.append(multiply % 10);
                carry = multiply / 10;
            }
            if (carry != 0) cur.append(carry);
            carry = 0;
            String addnum = cur.toString();
            StringBuilder newresult = new StringBuilder();
            int astart = 0, bstart = 0;
            while (astart < addnum.length() || bstart < result.length()) {
                int sum = carry;
                if (astart < addnum.length()) sum += addnum.charAt(astart++) - 48;
                if (bstart < result.length()) sum += result.charAt(bstart++) - 48;
                newresult.append(sum % 10);
                carry = sum / 10;
            }
            if (carry != 0) newresult.append(carry);
            result = newresult.toString();
        }
        StringBuffer sb = new StringBuffer(result);
        sb = sb.reverse();
        return sb.toString();
    }

    //牛逼解
    public String multiply3(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int[] pos = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - 48) * (num2.charAt(j) - 48);
                int p = i + j, q = i + j + 1;
                int sum = mul + pos[q];
                pos[p] += sum / 10;
                pos[q] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : pos)
            if (!(sb.length() == 0 && i == 0)) sb.append(i);
        return sb.toString();
    }
}
