import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lee310_MinHeightTrees_medium {
    private int maxNode, maxDepth;
    private List<Integer> roots = new LinkedList<>();

    private void dfs(int from, int depth, List<Integer>[] graph, boolean[] visited, int[] dist, int[] prev) {
        if (depth > maxDepth) {
            maxDepth = depth;
            maxNode = from;
        }
        for (int next : graph[from]) {
            if (visited[next]) continue;
            visited[next] = true;
            prev[next] = from;
            dist[next] = depth + 1;
            dfs(next, depth + 1, graph, visited, dist, prev);
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) graph[i] = new LinkedList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int[] dist1 = new int[n];
        int[] prev1 = new int[n];
        maxNode = 0;
        maxDepth = 0;
        visited[0] = true;
        dfs(0, 0, graph, visited, dist1, prev1);
        int node1 = maxNode;
        int[] dist2 = new int[n];
        int[] prev2 = new int[n];
        Arrays.fill(visited, false);
        maxNode = node1;
        maxDepth = 0;
        visited[node1] = true;
        dfs(node1, 0, graph, visited, dist2, prev2);
        int node2 = maxNode;
        for (int i = 0; i < maxDepth / 2; i++) node2 = prev2[node2];
        if ((maxDepth & 1) == 0) roots.add(node2);
        else {
            roots.add(node2);
            roots.add(prev2[node2]);
        }
        return roots;
    }
}
