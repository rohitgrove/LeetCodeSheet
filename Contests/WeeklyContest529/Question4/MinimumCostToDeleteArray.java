import java.util.Arrays;

public class MinimumCostToDeleteArray {
    public static long minCost(int[] nums) {
        int n = nums.length;
        long INF = Long.MAX_VALUE / 4;
        long dp[][] = new long[n][2];

        for (long[] row : dp) {
            Arrays.fill(row, Long.MIN_VALUE);
        }

        return (long) nums[0] + nums[n - 1] + solve(nums, 1, 0, dp, INF);
    }

    public static long solve(int nums[], int index, int parity, long dp[][], long INF) {
        if (index == nums.length - 1) {
            return parity == 0 ? 0 : INF;
        }

        if (dp[index][parity] != Long.MIN_VALUE) {
            return dp[index][parity];
        }

        long skip = solve(nums, index + 1, parity, dp, INF);
        long take = nums[index] + solve(nums, index + 1, parity ^ 1, dp, INF);
        return dp[index][parity] = Math.min(skip, take);
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, -7, 3, -5 };
        System.out.println(minCost(nums1));
        int[] nums2 = { 4, 0, -5, 2 };
        System.out.println(minCost(nums2));
        int[] nums3 = { 7, -8, 1 };
        System.out.println(minCost(nums3));
    }
}
