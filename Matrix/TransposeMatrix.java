public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int transpos[][] = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transpos[j][i] = matrix[i][j];
            }
        }
        return transpos;
    }

    public static void printMat(int[][] matrix) {
        for (int[] mat : matrix) {
            for (int ele : mat) {
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

        printMat(transpose(matrix1));

        int matrix2[][] = { { 1, 2, 3 },
                { 4, 5, 6 } };
        printMat(transpose(matrix2));
    }
}
