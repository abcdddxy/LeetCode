import java.util.Stack;

public class lee20_ValParent_easy {
    public boolean isValid(String s) {
        int[] res = {0, 0, 0};

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    res[0]++;
                    break;
                case ')':
                    res[0]--;
                    break;
                case '[':
                    res[1]++;
                    break;
                case ']':
                    res[1]--;
                    break;
                case '{':
                    res[2]++;
                    break;
                case '}':
                    res[2]--;
                    break;
            }
        }
        return res[0] == 0 && res[1] == 0 && res[2] == 0;
    }

    //栈
    public boolean isValid2(String s) {
        Stack res = new Stack();
        res.push('+');
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    res.push(c);
                    break;
                case ')':
                    if (res.peek().equals('(')) {
                        res.pop();
                    } else {
                        return false;
                    }
                    break;
                case '[':
                    res.push(c);
                    break;
                case ']':
                    if (res.peek().equals('[')) {
                        res.pop();
                    } else {
                        return false;
                    }
                    break;
                case '{':
                    res.push(c);
                    break;
                case '}':
                    if (res.peek().equals('{')) {
                        res.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return res.peek().equals('+');
    }
}
