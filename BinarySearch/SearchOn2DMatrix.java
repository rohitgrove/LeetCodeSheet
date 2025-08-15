public class SearchOn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int size = rowSize * colSize;

        int s = 0;
        int e = size - 1;

        int mid = s + (e - s) / 2;

        while (s <= e) {
            int rowIdx = mid / colSize;
            int colIdx = mid % colSize;
            int currNum = matrix[rowIdx][colIdx];
            if (currNum == target) {
                return true;
            } else if (currNum < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }

            mid = s + (e - s) / 2;
        }

        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,3,5,7},
        {10,11,16,20},
        {23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix(matrix, 13));
    }
}
