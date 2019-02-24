import java.util.LinkedList;
import java.util.List;

public class lee93_RestoreIP_medium {
    List<String> ans = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return ans;
        ipAdress("", 0, s);
        return ans;
    }

    private void ipAdress(String tmp, int n, String s) {
        System.out.println("ans = [" + ans.toString() + "], tmp = [" + tmp + "], n = [" + n + "], s = [" + s + "]");
        if (s.length() == 0 || n > 4) return;
        if (n == 3 && (s.length() == 1 || s.charAt(0) != '0') && Long.valueOf(s) <= 255) {
            ans.add(tmp + s);
            return;
        }
        ipAdress(tmp + s.substring(0, 1) + ".", n + 1, s.substring(1));
        if (s.length() >= 2 && s.charAt(0) != '0') ipAdress(tmp + s.substring(0, 2) + ".", n + 1, s.substring(2));
        if (s.length() >= 3 && s.charAt(0) != '0' && Integer.valueOf(s.substring(0, 3)) <= 255)
            ipAdress(tmp + s.substring(0, 3) + ".", n + 1, s.substring(3));
    }
}
