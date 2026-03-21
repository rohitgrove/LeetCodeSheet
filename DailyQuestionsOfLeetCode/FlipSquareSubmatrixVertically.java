public class FlipSquareSubmatrixVertically {
    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k >> 1; j++) {
                int temp = grid[x + j][y + i];
                grid[x + j][y + i] = grid[x + k - j - 1][y + i];
                grid[x + k - j - 1][y + i] = temp;
            }
        }

        return grid;
    }

    public static void printArr(int grid[][]) {
        for (int[] row : grid) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int grid1[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printArr(reverseSubmatrix(grid1, 1, 0, 3));
        int grid2[][] = { { 3, 4, 2, 3 },
                { 2, 3, 4, 2 } };
        printArr(reverseSubmatrix(grid2, 0, 2, 2));
    }
}
