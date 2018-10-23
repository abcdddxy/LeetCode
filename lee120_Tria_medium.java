import java.util.LinkedList;
import java.util.List;

public class lee120_Tria_medium {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0);
        List<Integer> dis = new LinkedList<>();
        dis = triangle.get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> current = new LinkedList<>();
            List<Integer> raw = triangle.get(i);
            for (int j = 0; j < raw.size(); j++) {
                if (j == 0) current.add(dis.get(j) + raw.get(j));
                else if (j == raw.size() - 1) current.add(dis.get(j - 1) + raw.get(j));
                else current.add(Math.min(dis.get(j - 1), dis.get(j)) + raw.get(j));
            }
            dis = current;
        }
        int min = Integer.MAX_VALUE;
        for (Integer i : dis) min = Math.min(min, i);
        return min;
    }

    //dp，反向dp
    public int minimumTotal2(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {

        }
    }
}
