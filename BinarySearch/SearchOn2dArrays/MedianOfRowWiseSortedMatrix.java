import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfRowWiseSortedMatrix {
    public static int bruteForce(int[][] matrix) {
        List<Integer> elements = new ArrayList<>();

        // Traverse each row of the matrix
        for (int[] row : matrix) {

            // Traverse each element in the current row
            for (int val : row) {

                // Add element to list
                elements.add(val);
            }
        }

        // Sort the list of elements
        Collections.sort(elements);

        // Return the middle element (median)
        int n = elements.size();
        return elements.get(n / 2);
    }

    public static int countLessEqual(int[] row, int mid) {
        // Binary search in row
        int low = 0, high = row.length;
        while (low < high) {
            int m = (low + high) / 2;
            if (row[m] <= mid) {
                low = m + 1;
            } else {
                high = m;
            }
        }
        return low;
    }

    public static int optimizedApproach(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Initialize low and high values
        int low = matrix[0][0];
        int high = matrix[0][cols - 1];
        for (int i = 1; i < rows; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][cols - 1]);
        }

        // Binary search in value range
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;

            // Count number of elements ≤ mid
            for (int i = 0; i < rows; i++) {
                count += countLessEqual(matrix[i], mid);
            }

            if (count < (rows * cols + 1) / 2) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // Return the median
        return low;
    }

    public static int median(int[][] mat) {
        return bruteForce(mat);
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 } };
        System.out.println(median(mat));
    }
}
