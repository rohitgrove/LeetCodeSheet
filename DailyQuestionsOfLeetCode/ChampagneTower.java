public class ChampagneTower {
    public static double solveUsingRec(int poured, int i, int j) {
        if (j < 0 || j > i) {
            return 0.0;
        }

        if (i == 0 && j == 0) {
            return poured;
        }

        double leftParent = solveUsingRec(poured, i - 1, j - 1);
        double rightParent = solveUsingRec(poured, i - 1, j);

        double leftOverflow = 0.0;
        double rightOverflow = 0.0;

        if (leftParent > 1) {
            leftOverflow = (leftParent - 1) / 2.0;
        }

        if (rightParent > 1) {
            rightOverflow = (rightParent - 1) / 2.0;
        }

        return leftOverflow + rightOverflow;
    }

    public static double solveUsingMemo(int poured, int i, int j, double dp[][]) {
        if (j < 0 || j > i) {
            return 0.0;
        }

        if (i == 0 && j == 0) {
            return poured;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        double leftParent = solveUsingMemo(poured, i - 1, j - 1, dp);
        double rightParent = solveUsingMemo(poured, i - 1, j, dp);

        double leftOverflow = 0.0;
        double rightOverflow = 0.0;

        if (leftParent > 1) {
            leftOverflow = (leftParent - 1) / 2.0;
        }

        if (rightParent > 1) {
            rightOverflow = (rightParent - 1) / 2.0;
        }

        dp[i][j] = leftOverflow + rightOverflow;
        return dp[i][j];
    }

    public static double solveUsingTabu(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1) {
                    double overflow = (dp[i][j] - 1) / 2.0;

                    dp[i + 1][j] += overflow;
                    dp[i + 1][j + 1] += overflow;

                    dp[i][j] = 1;
                }
            }
        }

        return Math.min(1, dp[query_row][query_glass]);
    }

    public static double solveUsingTabuSO(int poured, int query_row, int query_glass) {
        double[] prev = new double[query_row + 2];
        prev[0] = poured;

        for (int row = 1; row <= query_row; row++) {
            double[] curr = new double[query_row + 2];
            for (int col = 0; col < row; col++) {

                if (prev[col] > 1.0) {
                    double overflow = (prev[col] - 1.0) / 2.0;

                    curr[col] += overflow;
                    curr[col + 1] += overflow;
                }
            }

            prev = curr;
        }

        return Math.min(1.0, prev[query_glass]);
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        // return Math.min(1.0, solveUsingRec(poured, query_row, query_glass));
        // double dp[][] = new double[101][101];
        // for (double[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // return Math.min(1.0, solveUsingMemo(poured, query_row, query_glass, dp));
        return Math.min(1.0, solveUsingTabuSO(poured, query_row, query_glass));
    }

    public static void main(String[] args) {
        System.out.println(champagneTower(1, 1, 1));
        System.out.println(champagneTower(2, 1, 1));
        System.out.println(champagneTower(100000009, 33, 17));
    }
}
