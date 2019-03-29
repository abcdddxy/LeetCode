public class offer70_MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return count(visited, threshold, 0, 0);
    }

    private int count(boolean[][] visited, int threshold, int i, int j) {
        int count = 0;
        if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length) return 0;
        if (!visited[i][j] && check(visited, threshold, i, j)) {
            visited[i][j] = true;
            count = 1 + count(visited, threshold, i - 1, j) + count(visited, threshold, i, j - 1)
                    + count(visited, threshold, i + 1, j) + count(visited, threshold, i, j + 1);
        }
        return count;
    }

    private boolean check(boolean[][] visited, int threshold, int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return threshold >= sum;
    }
}
