import java.util.Arrays;

public class lee12_IntToRoman_medium {
    public String intToRoman(int num) {
        String strs[] = new String[4];
        Arrays.fill(strs, "");
        for (int i = 3; num >= 1; i--) {
            if(num >= Math.pow(10, i)){
                strs[i] = toRoman(num);
                num = num % (int)Math.pow(10, i);
                System.out.println("str = [" + strs[i] + "]");
            }
            System.out.println("num = [" + num + "], Math = [" + Math.pow(10, i) + "]");
        }

        StringBuilder s = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if(!strs[i].equals("")){
                s.append(strs[i]);
            }
        }
        return s.toString();
    }

    public String toRoman(int num) {
        String str = "";
        if (num >= 1000) {
            while (num >= 1000) {
                str += "M";
                num -= 1000;
            }
        } else if (num >= 100) {
            if (num >= 900) {
                str += "CM";
                num -= 900;
            } else if (num >= 500) {
                str += "D";
                num -= 500;
            } else if (num >= 400) {
                str = "CD";
                num -= 400;
            }
            while (num >= 100) {
                str += "C";
                num -= 100;
            }
        } else if (num >= 10) {
            if (num >= 90) {
                str += "XC";
                num -= 90;
            } else if (num >= 50) {
                str += "L";
                num -= 50;
            } else if (num >= 40) {
                str = "XL";
                num -= 40;
            }
            while (num >= 10) {
                str += "X";
                num -= 10;
            }
        } else {
            if (num >= 9) {
                str += "IX";
                num -= 9;
            } else if (num >= 5) {
                str += "V";
                num -= 5;
            } else if (num >= 4) {
                str = "IV";
                num -= 4;
            }
            while (num >= 1) {
                str += "I";
                num -= 1;
            }
        }
        return str;
    }

    //粗暴解法
    public String intToRoman2(int num) {
        String[] K1000 = { "", "M", "MM", "MMM" };
        String[] K100 = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] K10 = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] K1 = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        StringBuilder sb = new StringBuilder();
        sb.append(K1000[num / 1000]);
        sb.append(K100[(num / 100) % 10]);
        sb.append(K10[(num / 10) % 10]);
        sb.append(K1[num % 10]);
        return sb.toString();
    }
}
