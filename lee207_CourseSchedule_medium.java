import java.util.*;

public class lee207_CourseSchedule_medium {
    // 拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        int count = 0;
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList();
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]] += 1;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int q = queue.poll();
            for (int i = 0; i < numCourses; i++) {
                if (graph[i].contains(q)) {
                    graph[i].remove(Integer.valueOf(q));
                    degree[i]--;
                    if (degree[i] == 0) {
                        queue.offer(i);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }

    // DFS，判断无环
    private boolean ans = true;

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : prerequisites) {
            if (!map.containsKey(edge[1])) map.put(edge[1], new LinkedList<>());
            map.get(edge[1]).add(edge[0]);
        }
        System.out.println(map.toString());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numCourses; i++) noCycle(i, set, map);
        return ans;
    }

    private void noCycle(int i, Set<Integer> set, Map<Integer, List<Integer>> map) {
        System.out.println("i = [" + i + "], set = [" + set.toString() + "]");
        if (!map.containsKey(i) || map.get(i).size() == 0) return;
        if (!set.add(i)) {
            ans = false;
            return;
        }
        for (int ii : map.get(i)) noCycle(ii, new HashSet<>(set), map);
    }
}
