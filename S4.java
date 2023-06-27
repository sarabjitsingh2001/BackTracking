import java.util.ArrayList;

public class S4 {
    static ArrayList<String> list;

    public S4() {
        list = new ArrayList<>();
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] visited = new boolean[n][n];
        dfs(m, 0, 0, n, visited, "");
        return list;
    }

    static void dfs(int[][] m, int row, int column, int n, boolean[][] visited, String path) {
        if (row < 0 || column < 0 || row >= n || column >= n)
            return;
        if (visited[row][column])
            return;
        if (m[row][column] == 0)
            return;
        visited[row][column] = true;

        if (row == n - 1 && column == n - 1)
            list.add(path);

        dfs(m, row - 1, column, n, visited, path.concat("U")); // Up
        dfs(m, row + 1, column, n, visited, path.concat("D")); // Down
        dfs(m, row, column - 1, n, visited, path.concat("L")); // Left
        dfs(m, row, column + 1, n, visited, path.concat("R")); // Right

        visited[row][column] = false;
    }
}
