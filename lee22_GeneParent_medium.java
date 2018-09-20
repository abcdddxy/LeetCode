import java.util.*;


class Status {
    public int n_left;
    public int n_right;
    public String s;

    Status(int a, int b, String c) {
        n_left = a;
        n_right = b;
        s = c;
    }
}

public class lee22_GeneParent_medium {
    //递归
    public List<String> generateParenthesis(int n) {
        List<String> strs = new LinkedList<String>();
        char[] pars = new char[2 * n];
        pars[0] = '(';
        getStrs(strs, 1, n, 1, pars);

        return strs;
    }

    public void getStrs(List<String> strs, int flag, int n, int i, char[] pars) {
        if (flag < 0) {
            return;
        }
        if (i == 2 * n) {
            if (pars[2 * n - 1] == ')' && flag == 0) {
                strs.add(String.valueOf(pars));
            }
            return;
        }

        pars[i] = '(';
        getStrs(strs, flag + 1, n, i + 1, pars);
        pars[i] = ')';
        getStrs(strs, flag - 1, n, i + 1, pars);
    }

    //DFS
    public List<String> generateParenthesis2(int n) {
        Stack<Status> s = new Stack<>();
        List<String> res = new ArrayList<>();
        if (n < 1) return res;

        s.push(new Status(1, 0, "("));
        while (!s.empty()) {
            Status ss = s.pop();
            if (ss.n_left == n && ss.n_right == n) {
                res.add(ss.s);
                continue;
            }

            if (ss.n_left < n) {
                s.push(new Status(ss.n_left + 1, ss.n_right, ss.s + '('));
            }
            if (ss.n_left > ss.n_right) {
                s.push(new Status(ss.n_left, ss.n_right + 1, ss.s + ')'));
            }
        }
        return res;
    }

    //牛批闪闪的做法，依次找出每个n的解
    public List<String> generateParenthesis4(int n) {
        List<String>[] strs = new LinkedList[n + 1];
        strs[0] = new LinkedList<String>(Arrays.asList(""));
        for (int i = 1; i <= n; i++) {
            strs[i] = new LinkedList<String>();
            for (int j = 0; j < i; j++) {
                for (String s1 : strs[j]) {
                    for (String s2 : strs[i - 1 - j]) {
                        strs[i].add(String.format("(%s)%s", s1, s2));
                    }
                }
            }
        }
        return strs[n];
    }
}
