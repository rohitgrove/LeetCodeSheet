import java.util.Arrays;

public class FindRowWithMaximum1s {
    public static int[] rowAndMaximumOnes(int[][] mat) {
        int ans[] = new int[2];
        int oneCount = Integer.MIN_VALUE;
        int rowNo = 0;

        for (int i = 0; i < mat.length; i++) {
            int count = 0;

            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }

            if (count > oneCount) {
                oneCount = count;
                rowNo = i;
            }
        }

        ans[0] = rowNo;
        ans[1] = oneCount;
        return ans;
    }

    public static int lowerBound(int[] nums, int x) {
        int n = nums.length;
        int low = 0, high = n - 1;

        Arrays.sort(nums);

        int ans = n; // Default value if no such index is found

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= x) {
                ans = mid; // Possible answer found
                high = mid - 1; // Try to find a smaller index
            } else {
                low = mid + 1; // Move right
            }
        }

        return ans; // Index of first element >= x
    }

    public static int[] rowAndMaximumOnes2(int[][] mat) {
        // This approach is good but when all 0s and 1s are sorted in each row.
        int m = mat.length;
        int n = mat[0].length;

        int max_cnt = 0; // Keeps track of the maximum number of 1s found so far
        int index = 0;// Stores index of the row with maximum 1s

        for (int i = 0; i < m; i++) {
            // Count of 1s = total columns - index of first 1 (lower bound)
            int cnt_row = n - lowerBound(mat[i], 1);

            if (cnt_row > max_cnt) {
                max_cnt = cnt_row;
                index = i;
            }
        }

        return new int[]{index, max_cnt}; // Return row index with maximum 1s
    }

    public static void printArr(int ans[]) {
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static void main(String[] args) {
        int mat1[][] = { { 0, 1 },
                { 1, 0 } };
        printArr(rowAndMaximumOnes(mat1));
        int mat2[][] = { { 0, 0, 0 },
                { 0, 1, 1 } };
        printArr(rowAndMaximumOnes(mat2));
        int mat3[][] = { { 0, 0 },
                { 1, 1 },
                { 0, 0 } };
        printArr(rowAndMaximumOnes(mat3));
    }
}
