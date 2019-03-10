public class lee316_RemoveDuplicateLetters_hard {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            count[s.charAt(i) - 'a']--;
            if (count[s.charAt(i) - 'a'] == 0) break;
        }
        String ans = String.valueOf(s.charAt(pos));
        return ans + removeDuplicateLetters(s.substring(pos + 1).replace(ans, ""));
    }
}
