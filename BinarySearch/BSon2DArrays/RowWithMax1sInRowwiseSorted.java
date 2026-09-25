public class RowWithMax1sInRowwiseSorted {
    public static int rowWithMax1s(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int row = 0;

        int col = cols - 1;

        int answer = -1;

        while (row < rows && col >= 0) {
            if (mat[row][col] == 1) {
                answer = row;
                col--;
            } else {
                row++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int arr[][] = { { 0, 1, 1, 1 },
                { 0, 0, 1, 1 },
                { 1, 1, 1, 1 } };

        System.out.println(rowWithMax1s(arr));
    }
}
