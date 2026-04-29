public class TransposeTheMatrix {
    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = r; c < matrix[0].length; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }

            int s = 0;
            int e = col - 1;

            while (s < e) {
                int temp = matrix[r][s];
                matrix[r][s] = matrix[r][e];
                matrix[r][e] = temp;
                s++;
                e--;
            }
        }
    }

    public static void printArr(int matrix[][]) {
        for (int[] row : matrix) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int matrix1[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        rotate(matrix1);
        printArr(matrix1);
        int matrix2[][] = { { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 } };
        rotate(matrix2);
        printArr(matrix2);
    }
}
