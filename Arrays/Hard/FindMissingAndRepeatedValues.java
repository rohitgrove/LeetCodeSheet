public class FindMissingAndRepeatedValues {
    public static int[] bruteForce(int[][] grid) {
        int gridSize = grid.length;
        int count[] = new int[(gridSize * gridSize) + 1];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                count[grid[i][j]]++;
            }
        }

        int ans[] = new int[2];
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 2) {
                ans[0] = i;
            }
            if (count[i] == 0) {
                ans[1] = i;
            }
        }
        return ans;
    }

    public static int[] optimizedApproch(int grid[][]) {
        int ans = 0;
        for (int[] grid1 : grid) {
            for (int j = 0; j < grid.length; j++) {
                ans ^= grid1[j];
            }
        }

        for (int i = 1; i <= grid.length * grid.length; i++) {
            ans ^= i;
        }

        int res[] = new int[] { ans };

        return res;
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        return optimizedApproch(grid);
    }

    public static void printArr(int[] ans) {
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int grid1[][] = { { 1, 3 },
                { 2, 2 } };
        printArr(findMissingAndRepeatedValues(grid1));
        int grid2[][] = { { 9, 1, 7 },
                { 8, 9, 2 },
                { 3, 4, 6 } };
        printArr(findMissingAndRepeatedValues(grid2));
    }
}
