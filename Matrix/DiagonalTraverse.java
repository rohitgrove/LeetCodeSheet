public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        int size = mat.length * mat[0].length;
        int[] ans = new int[size];
        int row = 0, col = 0;
        boolean up = true;

        for (int i = 0; i < size; i++) {
            ans[i] = mat[row][col];

            if (up) { // Moving upwards
                if (col == mat[0].length - 1) {
                    row++;
                    up = !up;
                } else if (row == 0) {
                    col++;
                    up = !up;
                } else {
                    row--;
                    col++;
                }
            } else { // Moving downwards
                if (row == mat.length - 1) {
                    col++;
                    up = !up;
                } else if (col == 0) {
                    row++;
                    up = !up;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return ans;
    }

    public static void printArr(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        printArr(findDiagonalOrder(mat));
    }
}
