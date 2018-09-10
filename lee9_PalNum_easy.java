public class lee9_PalNum_easy {
    public boolean isPalindrome(int x) {
        char[] ch = Integer.toString(x).toCharArray();

        if (x < 0) {
            return false;
        }

        if (x >= 0 && x < 10) {
            return true;
        }

        for (int i = 0; i < ch.length / 2; i++) {
            if(ch[i] != ch[ch.length - i - 1]){
                return false;
            }
        }
        return true;
    }
}
