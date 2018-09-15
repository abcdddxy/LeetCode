import java.util.HashMap;
import java.util.Map;

public class lee13_RomanToInt {
    public int romanToInt(String s) {
        Map roman = new HashMap<Character, Integer>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1) {
                if ((int) roman.get(s.charAt(i + 1)) > (int) roman.get(s.charAt(i))) {
                    res -= (int) roman.get(s.charAt(i));
                    System.out.println("res = [" + res + "]");
                } else {
                    res += (int) roman.get(s.charAt(i));
                    System.out.println("res = [" + res + "]");
                }
            } else {
                res += (int) roman.get(s.charAt(i));
                System.out.println("res = [" + res + "]");
            }
        }
        return res;
    }

    //倒序遍历
    public int romanToInt2(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'V':
                    res += 5;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'I':
                    res += res >= 5 ? -1 : 1;
                    break;
                case 'X':
                    res += res>=50?-10:10;
                    break;
                case 'C':
                    res += res>=500?-100:100;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }
}
