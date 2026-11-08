public class CountServersThatCommunicate {
    public static int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int grid1[][] = { { 1, 0 },
                { 0, 1 } };
        System.out.println(countServers(grid1));
        int grid2[][] = { { 1, 0 },
                { 1, 1 } };
        System.out.println(countServers(grid2));
        int grid3[][] = { { 1, 1, 0, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 1 } };
        System.out.println(countServers(grid3));
    }
}