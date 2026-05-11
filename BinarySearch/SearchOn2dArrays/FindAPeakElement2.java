public class FindAPeakElement2 {
    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int startCol = 0;
        int endCol = m - 1;

        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol) / 2;

            // 1. Find the row with the maximum element in the current midCol
            int maxRow = 0;
            for (int i = 0; i < n; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            // 2. Compare with Left and Right neighbors
            // Check Left Neighbor
            boolean isLeftBig = midCol > 0 && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
            // Check Right Neighbor
            boolean isRightBig = midCol < m - 1 && mat[maxRow][midCol + 1] > mat[maxRow][midCol];

            if (isLeftBig) {
                // Peak must be on the left side
                endCol = midCol - 1;
            } else if (isRightBig) {
                // Peak must be on the right side
                startCol = midCol + 1;
            } else {
                // Determine if it is a peak:
                // It is already max in its column (so > top and bottom).
                // We checked left and right, and neither is bigger.
                return new int[] { maxRow, midCol };
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int mat1[][] = { { 1, 4 },
                { 3, 2 } };
        int ans1[] = findPeakGrid(mat1);
        System.out.println(ans1[0] + " " + ans1[1]);
        int mat2[][] = { { 10, 20, 15 },
                { 21, 30, 14 },
                { 7, 16, 32 } };
        int ans2[] = findPeakGrid(mat2);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}
