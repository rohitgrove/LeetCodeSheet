import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifferenceInSlidingSubmatrix {
    public static int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                List<Integer> temp = new ArrayList<>();

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        temp.add(grid[x][y]);
                    }
                }

                if (k == 1) {
                    ans[i][j] = 0;
                    continue;
                }

                Collections.sort(temp);

                List<Integer> unique = new ArrayList<>();
                for (int num : temp) {
                    if (unique.isEmpty() || unique.get(unique.size() - 1) != num) {
                        unique.add(num);
                    }
                }

                if (unique.size() <= 1) {
                    ans[i][j] = 0;
                    continue;
                }

                int mini = Integer.MAX_VALUE;
                for (int p = 1; p < unique.size(); p++) {
                    mini = Math.min(mini, Math.abs(unique.get(p) - unique.get(p - 1)));
                }

                ans[i][j] = mini;
            }
        }

        return ans;
    }

    public static void printGrid(int[][] grid) {
        for (int[] arr : grid) {
            for (int ele : arr) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int grid1[][] = { { 1, 8 },
                { 3, -2 } };
        printGrid(minAbsDiff(grid1, 2));
        int grid2[][] = { { 3, -1 } };
        printGrid(minAbsDiff(grid2, 1));
        int grid3[][] = { { 1, -2, 3 },
                { 2, 3, 5 } };
        printGrid(minAbsDiff(grid3, 2));
    }
}
