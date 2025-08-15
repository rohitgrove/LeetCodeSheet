public class MedianInARowWiseSortedMatrix {
    public static int median(int[][] mat) {
        int rowSize = mat.length;
        int colSize = mat[0].length;

        int size = rowSize * colSize;

        int s = 0;
        int e = size - 1;

        int mid = s + (e - s) / 2;

        return mat[mid / colSize][mid % colSize];
    }

    public static void main(String[] args) {
        int mat1[][] = { { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 } };
        System.out.println(median(mat1));
        int mat2[][] = { { 2, 4, 9 },
                { 3, 6, 7 },
                { 4, 7, 10 } };
        System.out.println(median(mat2));
        int mat3[][] = { { 3 },
                { 4 },
                { 8 } };
        System.out.println(median(mat3));
    }
}
