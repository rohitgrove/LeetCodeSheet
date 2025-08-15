public class SetMatrixZeroes {
    public static void bruteForce(int[][] matrix) {
        // step1: Create an auxiliary matrix ( marks ) of the same size as the input
        // matrix.
        // Initialize all elements in marks as False.
        boolean[][] marks = new boolean[matrix.length][matrix[0].length];

        // step2: Loop through each element in the input matrix.
        // Whenever you encounter a 0 at position (i, j), update marks[i][j] to True.
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[0].length; j++) {
                if (matrix[i][j] == 0) {
                    marks[i][j] = true;
                }
            }
        }

        // step3: Loop through the matrix again. For each element (i, j):
        // If marks[i][k] for any column k in the same row or marks[l][j] for any row l
        // in the same column is True, set matrix[i][j] = 0.

        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[0].length; j++) {
                if (marks[i][j]) {
                    // set entire row i to 0
                    for (int k = 0; k < marks[0].length; k++) {
                        matrix[i][k] = 0;
                    }

                    // set entire column j to 0
                    for (int l = 0; l < marks.length; l++) {
                        matrix[l][j] = 0;
                    }
                }
            }
        }
    }

    public static void optimizedForce(int[][] matrix) {
        // Step1: Create two Boolean arrays, rows and columns, to track which rows and
        // columns need to be set to 0.
        // rows should have a size equal to the number of rows in the matrix.
        // columns should have a size equal to the number of columns in the matrix.
        // Initialize both arrays to False.
        boolean rows[] = new boolean[matrix.length];
        boolean cols[] = new boolean[matrix[0].length];

        // step2: Iterate through the matrix using a nested loop:
        // Outer loop for rows (i from 0 to m-1).
        // Inner loop for columns (j from 0 to n-1).
        // If matrix[i][j] == 0, mark:
        // rows[i] = True (indicating row i has a 0).
        // columns[j] = True (indicating column j has a 0).
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // step3: Iterate through the matrix again:
        // For each cell matrix[i][j]:
        // If rows[i] == True or columns[j] == True, set matrix[i][j] = 0.

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        optimizedForce(matrix);
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
        int matrix1[][] = { { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } };
        int matrix2[][] = { { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 } };

        System.out.println("Before set matrix");
        printMat(matrix1);
        printMat(matrix2);

        setZeroes(matrix1);
        setZeroes(matrix2);

        System.out.println("After set matrix");
        printMat(matrix1);
        printMat(matrix2);
    }
}
