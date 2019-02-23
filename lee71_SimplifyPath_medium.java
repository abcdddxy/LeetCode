import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lee71_SimplifyPath_medium {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        while (path.length() > 0) {
            int start = path.indexOf('/');
            path = path.substring(start + 1);
            int end = path.indexOf('/');
            if (end == -1) end = path.length();
            String part = path.substring(0, end);
            path = path.substring(end);
            // System.out.println(part+'  '+path);
            if (part.equals(".") || part.equals(""))
                continue;
            if (part.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else stack.push('/' + part);
        }
        String result = "";
        while (!stack.isEmpty()) result += stack.pop();
        if (result.length() == 0)
            result = "/";
        return result;
    }
}
