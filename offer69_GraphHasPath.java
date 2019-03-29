public class offer69_GraphHasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] graph = new char[rows][cols];
        for (int i = 0; i < matrix.length; i++) graph[i / cols][i % cols] = matrix[i];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] visited = new boolean[rows][cols];
                if (graph[i][j] == str[0] && dfs(graph, visited, i, j, str, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] graph, boolean[][] visited, int i, int j, char[] str, int order) {
        if (order == str.length) return true;
        if (i < 0 || j < 0 || i >= graph.length || j >= graph[0].length) return false;
        if (graph[i][j] == str[order] && !visited[i][j]) {
            visited[i][j] = true;
            return dfs(graph, visited, i - 1, j, str, order + 1)
                    || dfs(graph, visited, i, j - 1, str, order + 1)
                    || dfs(graph, visited, i + 1, j, str, order + 1)
                    || dfs(graph, visited, i, j + 1, str, order + 1);
        } else return false;
    }
}
