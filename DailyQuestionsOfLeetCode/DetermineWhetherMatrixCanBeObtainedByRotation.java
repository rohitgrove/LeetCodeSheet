public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public static boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (areEqual(mat, target)) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }

    public static boolean areEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse -> 2D MATTIX ki ssaari rows ko
        // kitni rows h -> 0 > (n-1)
        for (int i = 0; i < n; i++) {
            // hr row ko reverse krna h
            reverseArr(matrix[i]);
        }
    }

    public static void reverseArr(int arr[]) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int mat1[][] = { { 0, 1 }, { 1, 0 } },
                target1[][] = { { 1, 0 }, { 0, 1 } };
        System.out.println(findRotation(mat1, target1));

        int mat2[][] = { { 0, 1 }, { 1, 1 } },
                target2[][] = { { 1, 0 }, { 0, 1 } };
        System.out.println(findRotation(mat2, target2));

        int mat3[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } },
                target3[][] = { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(findRotation(mat3, target3));
    }
}