public class ReshapeTheMatrix {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int totalElements = mat.length * mat[0].length;
        if (totalElements != r * c) {
            return mat;
        }

        int ans[][] = new int[r][c];
        int row = 0;
        int col = 0;
        for (int[] matRow : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                ans[row][col] = matRow[j];
                col++;

                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }

        return ans;
    }

    public static void printArr(int res[][]) {
        for (int[] row : res) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2 },
                { 3, 4 } };
        printArr(matrixReshape(mat, 1, 4));
        printArr(matrixReshape(mat, 2, 4));
    }
}
