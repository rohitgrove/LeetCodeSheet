import java.util.Arrays;

public class MinimumOperationsToFormSubsetSum1 {
    public static int minOperations(int[] nums, int sum) {
        int[][] dp = new int[nums.length][sum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(nums, 0, sum, dp);

        return ans >= 1000000000 ? -1 : ans;
    }

    public static int solve(int[] nums, int index, int target, int dp[][]) {
        if (target == 0) {
            return 0;
        }

        if (index == nums.length) {
            return 1000000000;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int ans = solve(nums, index + 1, target, dp);

        int value = nums[index];
        int cost = 0;

        while (target >= value) {
            ans = Math.min(ans, cost + solve(nums, index + 1, target - value, dp));
            if (value > target / 2) {
                break;
            }
            value *= 2;
            cost++;
        }

        value = nums[index] / 2;
        cost = 1;

        while (value > 0) {
            if (target >= value) {
                ans = Math.min(ans, cost + solve(nums, index + 1, target - value, dp));
            }

            value /= 2;
            cost++;
        }

        return dp[index][target] = ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 5, 6, 10 };
        System.out.println(minOperations(nums1, 4));

        int[] nums2 = { 10, 2 };
        System.out.println(minOperations(nums2, 13));

        int[] nums3 = { 6, 3 };
        System.out.println(minOperations(nums3, 8));
    }
}
