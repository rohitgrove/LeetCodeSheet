public class ConstructProductMatrix {
    public static int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int[][] p = new int[n][m];

        long suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                p[i][j] = (int) suffix;
                suffix = (suffix * grid[i][j]) % MOD;
            }
        }

        long prefix = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = (int) (((long) p[i][j] * prefix) % MOD);
                prefix = (prefix * grid[i][j]) % MOD;
            }
        }

        return p;
    }

    public static void printArr(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int grid1[][] = { { 1, 2 },
                { 3, 4 } };
        printArr(constructProductMatrix(grid1));
        int grid2[][] = { { 12345 },
                { 2 },
                { 1 } };
        printArr(constructProductMatrix(grid2));
    }
}
