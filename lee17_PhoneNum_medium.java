import java.util.*;

public class lee17_PhoneNum_medium {
    public List<String> letterCombinations(String digits) {
        List<String> strs = new LinkedList<>();
        Map<Character, String> phone = new HashMap<Character, String>();
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");

        for (int i = 0; i < digits.length(); i++) {
            strs = plusOneNum(strs, phone, digits.charAt(i));
        }
        return strs;
    }

    public List<String> plusOneNum(List<String> strs, Map<Character, String> phone, char num) {
        List<String> strsNew = new LinkedList<>();
        String tmp = phone.get(num);

        if (strs.size() == 0) {
            for (int i = 0; i < tmp.length(); i++) {
                strsNew.add(String.valueOf(tmp.charAt(i)));
            }
            return strsNew;
        }

        for (String str : strs) {
            for (int i = 0; i < tmp.length(); i++) {
                strsNew.add(str + tmp.charAt(i));
            }
        }
        return strsNew;
    }

    //递归
    private String[] STR = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations2(String digits) {
        List<String> strs = new LinkedList<>();

        if (!digits.isEmpty()) {
            getStr(strs, 0, digits, "");
        }

        return strs;
    }

    public void getStr(List<String> strs, int start, String digits, String s) {
        if (start == digits.length()) {
            strs.add(s);
            return;
        }

        for (char c : STR[digits.charAt(start) - '0'].toCharArray()) {
            getStr(strs, start + 1, digits, s + c);
        }
    }

    //非递归，DFS
    public List<String> letterCombinations3(String digits) {
        LinkedList<String> queue = new LinkedList<String>(); //队列
        if (digits.isEmpty()) {
            return queue;
        }

        Queue<String> next = new LinkedList<>(); //队列，可以用Queue或LinkedList
        queue.add("");

        for (int i = 0; i < digits.length() && !queue.isEmpty(); ) {
            String s = queue.poll();
            System.out.println("s = [" + s + "]");
            for (char c : STR[digits.charAt(i) - '0'].toCharArray()) {
                next.add(s + c);
            }
            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                i++;
            }
        }
        return queue;
    }
}
