public class SetMatrixZero {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        // Step 1: Mark rows and columns
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Step 2: Update matrix
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
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
        int matrix1[][] = { { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } };
        System.out.println("Before Update");
        printArr(matrix1);
        System.out.println("After Update");
        setZeroes(matrix1);
        printArr(matrix1);

        int matrix2[][] = { { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 } };
        System.out.println("Before Update");
        printArr(matrix2);
        System.out.println("After Update");
        setZeroes(matrix2);
        printArr(matrix2);
    }
}
