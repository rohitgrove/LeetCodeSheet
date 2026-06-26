import java.util.ArrayList;

public class RatInAMaze {
    public static void solve(int[][] maze, int row, int col, ArrayList<String> ans, String path, boolean[][] vis) {
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || vis[row][col] || maze[row][col] == 0) {
            return;
        }

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            ans.add(path);
            return;
        }

        vis[row][col] = true;
        
        solve(maze, row + 1, col, ans, path + "D", vis);
        solve(maze, row, col - 1, ans, path + "L", vis);
        solve(maze, row, col + 1, ans, path + "R", vis);
        solve(maze, row - 1, col, ans, path + "U", vis);

        vis[row][col] = false;
    }

    public static ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        boolean vis[][] = new boolean[maze.length][maze[0].length];
        solve(maze, 0, 0, ans, "", vis);
        return ans;
    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };
        System.out.println(ratInMaze(maze));
    }
}
