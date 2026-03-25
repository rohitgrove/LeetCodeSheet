public class EqualSumGridPartition1 {
    public static boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long total = 0;

        for (int[] row : grid) {
            for (int x : row) {
                total += x;
            }
        }

        if ((total & 1) == 1) {
            return false;
        }

        long target = total / 2, sum = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
            if (sum == target){
                return true;
            }
        }

        sum = 0;

        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++){
                sum += grid[i][j];
            }
            if (sum == target) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int grid1[][] = { { 1, 4 }, { 2, 3 } };
        System.out.println(canPartitionGrid(grid1));
        int grid2[][] = { { 1, 3 }, { 2, 4 } };
        System.out.println(canPartitionGrid(grid2));
    }
}
