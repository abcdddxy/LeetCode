public class offer44_ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null) return null;
        if (str.trim().equals("")) return str;
        String[] strings = str.split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (i == 0) {
                sBuilder.append(strings[i]);
            } else {
                sBuilder.append(strings[i]);
                sBuilder.append(" ");
            }
        }
        return sBuilder.toString();
    }
}
