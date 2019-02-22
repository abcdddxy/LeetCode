import java.util.ArrayList;
import java.util.List;

public class lee68_TextJustification_hard {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int pos = 0;
        int len = 0;
        int w = 0;
        for (int i = 0; i < words.length; i++) {
            len += words[i].length();
            w++;
            if (len + (w - 1) > maxWidth) {
                StringBuilder sb = new StringBuilder();
                int remainSpaces = maxWidth - (len - words[i].length());
                int remainWords = w - 2;
                int space = remainWords > 0 ? (int) Math.ceil((double) remainSpaces / remainWords) : remainSpaces;
                for (int j = 0; j < w - 1; j++) {
                    sb.append(words[i + 1 - w + j]);

                    for (int k = 0; k < space; k++) sb.append(' ');
                    remainSpaces -= space;
                    remainWords--;
                    space = remainWords > 0 ? (int) Math.ceil((double) remainSpaces / remainWords) : remainSpaces;
                }
                ans.add(sb.toString());
                len = words[i].length();
                w = 1;
            }
            if (i == words.length - 1) {
                StringBuilder sb = new StringBuilder();
                int remainSpaces = maxWidth - len;
                int space = 1;
                for (int j = 0; j < w; j++) {
                    sb.append(words[i + 1 - w + j]);
                    if (j < w - 1) space = 1;
                    else space = remainSpaces;
                    for (int k = 0; k < space; k++) sb.append(' ');
                    remainSpaces -= space;
                }
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}
