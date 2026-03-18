public class CountSubmatricesWithTopLeftElementAndSumLessThanK {
    public static int countSubmatrices(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        int prefixSum[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixSum[i][j] = grid[i][j];
                if (i > 0) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                }
                if (j > 0) {
                    prefixSum[i][j] += prefixSum[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    prefixSum[i][j] -= prefixSum[i - 1][j - 1];
                }
                if (prefixSum[i][j] <= k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int grid1[][] = { { 7, 6, 3 },
                { 6, 6, 1 } }, k1 = 18;
        System.out.println(countSubmatrices(grid1, k1));
        int grid2[][] = { { 7, 2, 9 },
                { 1, 5, 0 },
                { 2, 6, 6 } }, k2 = 20;
        System.out.println(countSubmatrices(grid2, k2));
    }
}
