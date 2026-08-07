import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static int solveWithRec(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        int curr = solveWithRec(triangle, row + 1, col);
        int next = solveWithRec(triangle, row + 1, col + 1);
        int sum = triangle.get(row).get(col) + Math.min(curr, next);
        return sum;
    }

    public static int solveWithMemo(List<List<Integer>> triangle, int row, int col, int dp[][]) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        if (dp[row][col] != Integer.MIN_VALUE) {
            return dp[row][col];
        }

        int curr = solveWithMemo(triangle, row + 1, col, dp);
        int next = solveWithMemo(triangle, row + 1, col + 1, dp);
        int sum = triangle.get(row).get(col) + Math.min(curr, next);
        dp[row][col] = sum;
        return dp[row][col];
    }

    public static int solveWithTabu(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Base Case
        for (int col = 0; col < n; col++) {
            dp[n - 1][col] = triangle.get(n - 1).get(col);
        }

        // Bottom-Up
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int curr = dp[row + 1][col];
                int next = dp[row + 1][col + 1];

                int sum = triangle.get(row).get(col) + Math.min(curr, next);

                dp[row][col] = sum;
            }
        }

        return dp[0][0];
    }

    public static int solveWithTabuSO1(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] currRow = new int[n];
        int[] nextRow = new int[n];

        // Base Case
        for (int col = 0; col < n; col++) {
            nextRow[col] = triangle.get(n - 1).get(col);
        }

        // Bottom-Up
        for (int row = n - 2; row >= 0; row--) {
            for (int col = row; col >= 0; col--) {
                int curr = nextRow[col];
                int next = nextRow[col + 1];

                currRow[col] = triangle.get(row).get(col)
                        + Math.min(curr, next);
            }
            nextRow = currRow.clone();
        }

        return nextRow[0];
    }

    public static int solveWithTabuSO2(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] dp = new int[n];

        // Base Case
        for (int col = 0; col < n; col++) {
            dp[col] = triangle.get(n - 1).get(col);
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col)
                        + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }

    public static int solveWithTabuSO3(List<List<Integer>> triangle) {
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                int below = triangle.get(row + 1).get(col);
                int belowRight = triangle.get(row + 1).get(col + 1);

                triangle.get(row).set(
                        col,
                        triangle.get(row).get(col) + Math.min(below, belowRight));
            }
        }

        return triangle.get(0).get(0);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        // return solveWithRec(triangle, 0, 0);
        int dp[][] = new int[triangle.size() + 1][triangle.size() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return solveWithTabuSO1(triangle);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(2);
        triangle.add(new ArrayList<>());
        triangle.get(1).add(3);
        triangle.get(1).add(4);
        triangle.add(new ArrayList<>());
        triangle.get(2).add(6);
        triangle.get(2).add(5);
        triangle.get(2).add(7);
        triangle.add(new ArrayList<>());
        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
        triangle.get(3).add(3);
        System.out.println(triangle);
        System.out.println("Ans: " + minimumTotal(triangle));
    }
}
