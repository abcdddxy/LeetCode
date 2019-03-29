public class offer2_ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String ans = str.toString();
        return ans.replace(" ", "%20");
    }
}
