import java.util.Arrays;

public class FindXValueOfArray1 {
    public static long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] res = new long[k];

        for (int i = 0; i < n; i++) {
            nums[i] %= k;
        }

        for (int r = 0; r < k; r++) {
            long[][] dp = new long[n][k + 1];
            for (long[] row : dp) {
                Arrays.fill(row, -1);
            }
            res[r] = solveUsingMemo(0, k, r, k, nums, dp);
        }

        return res;
    }

    public static long solveUsingRec(int i, int prevProd, int req, int k, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }

        long skip = 0, take = 0;

        // Skip current element (only if no subarray started yet)
        if (prevProd == k) {
            skip = solveUsingRec(i + 1, k, req, k, nums);
        }

        // Take current element
        long curProd;
        if (prevProd == k) {
            curProd = nums[i];
        } else {
            curProd = ((long) prevProd * nums[i]) % k;
        }

        take += (curProd == req) ? 1 : 0;
        take += solveUsingRec(i + 1, (int) curProd, req, k, nums);

        return take + skip;
    }

    public static long solveUsingMemo(int i, int prevProd, int req, int k, int[] nums, long[][] dp) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i][prevProd] != -1) {
            return dp[i][prevProd];
        }

        long skip = 0, take = 0;

        // Skip current element (only if no subarray started yet)
        if (prevProd == k) {
            skip = solveUsingMemo(i + 1, k, req, k, nums, dp);
        }

        // Take current element
        long curProd;
        if (prevProd == k) {
            curProd = nums[i];
        } else {
            curProd = ((long) prevProd * nums[i]) % k;
        }

        take += (curProd == req) ? 1 : 0;
        take += solveUsingMemo(i + 1, (int) curProd, req, k, nums, dp);

        return dp[i][prevProd] = take + skip;
    }

    public static void printAns(long arr[]) {
        for (long ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 4, 5 };
        printAns(resultArray(nums1, 3));
        int nums2[] = { 1, 2, 4, 8, 16, 32 };
        printAns(resultArray(nums2, 4));
        int nums3[] = { 1, 1, 2, 1, 1 };
        printAns(resultArray(nums3, 2));
    }
}
