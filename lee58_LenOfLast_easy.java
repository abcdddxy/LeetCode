public class lee58_LenOfLast_easy {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        int lastBlank = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') lastBlank = i;
        }
        return lastBlank == 0 ? s.length() : s.length() - lastBlank - 1;
    }
}
