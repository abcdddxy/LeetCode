import java.util.*;

public class lee210_CourseSchedule2_medium {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] course = new List[numCourses];
        int[] map = new int[numCourses];
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < numCourses; i++)
            course[i] = new ArrayList<Integer>();
        for (int i = 0; i < prerequisites.length; i++) course[prerequisites[i][0]].add(prerequisites[i][1]);
        for (int i = 0; i < numCourses; i++) if (dfs(course, i, ans, map) == false) return new int[0];
        int[] an = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) an[i] = ans.get(i);
        return an;
    }

    public boolean dfs(List[] course, int req, List<Integer> ans, int[] map) {
        if (map[req] == 0) {
            map[req] = 1;
            for (int i = 0; i < course[req].size(); i++)
                if (dfs(course, (int) course[req].get(i), ans, map) == false) return false;
            map[req] = 2;
        } else if (map[req] == 1) return false;
        else if (map[req] == 2) return true;
        ans.add(req);
        return true;
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);
            indegree[dest] += 1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;
            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) q.add(neighbor);
                }
            }
        }
        if (i == numCourses) return topologicalOrder;
        return new int[0];
    }
}
