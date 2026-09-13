public class CyclicShiftRowsAndColumns {
    public static int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            int shift = rowShift[i] % n;

            for (int j = 0; j < n; j++) {
                temp[i][j] = grid[i][(j + shift) % n];
            }
        }
        int[][] ans = new int[n][n];

        for (int j = 0; j < n; j++) {
            int shift = colShift[j] % n;
            for (int i = 0; i < n; i++) {
                ans[i][j] = temp[(i + shift) % n][j];
            }
        }

        return ans;
    }

    public static void printAns(int ans[][]) {
        for (int[] row : ans) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int grid1[][] = { { 1, 2 }, { 3, 4 } }, rowShift1[] = { 1, 0 }, colShift1[] = { 0, 1 };
        printAns(cyclicShift(2, grid1, rowShift1, colShift1));
        int grid2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, rowShift2[] = { 1, 2, 0 }, colShift2[] = { 2, 2, 1 };
        printAns(cyclicShift(3, grid2, rowShift2, colShift2));
    }
}
