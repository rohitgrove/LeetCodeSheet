public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        boolean row[] = new boolean[matrix.length];
        boolean col[] = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void printArr(int matrix[][]) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int matrix1[][] = { { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } };
        setZeroes(matrix1);
        printArr(matrix1);

        int matrix2[][] = { { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 } };
        setZeroes(matrix2);
        printArr(matrix2);
    }
}
