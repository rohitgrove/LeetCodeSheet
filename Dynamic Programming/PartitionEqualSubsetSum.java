
public class PartitionEqualSubsetSum {
    public static boolean solveUsingRec(int[] nums, int index, int currSum, int target) {
        if (index >= nums.length) {
            return false;
        }

        if (currSum > target) {
            return false;
        }

        if (currSum == target) {
            return true;
        }

        boolean include = solveUsingRec(nums, index + 1, currSum + nums[index], target);
        boolean exclude = solveUsingRec(nums, index + 1, currSum, target);
        boolean ans = include || exclude;
        return ans;
    }

    public static boolean solveUsingMemo(int[] nums, int index, int currSum, int target, Boolean dp[][]) {
        if (index >= nums.length) {
            return false;
        }

        if (currSum > target) {
            return false;
        }

        if (currSum == target) {
            return true;
        }

        if (dp[index][currSum] != null) {
            return dp[index][currSum];
        }

        boolean include = solveUsingMemo(nums, index + 1, currSum + nums[index], target, dp);
        boolean exclude = solveUsingMemo(nums, index + 1, currSum, target, dp);
        dp[index][currSum] = include || exclude;
        return dp[index][currSum];
    }

    public static boolean solveUsingTabu(int[] nums, int target) {
        int dp[][] = new int[nums.length + 2][target + 1];

        for (int row = 0; row < dp.length; row++) {
            dp[row][target] = 1;
        }

        for (int index = nums.length - 1; index >= 0; index--) {
            for (int sum = target; sum >= 0; sum--) {
                boolean include = false;
                if (sum + nums[index] <= target) {
                    include = dp[index + 1][sum + nums[index]] == 1;

                }
                boolean exclude = dp[index + 1][sum] == 1;
                dp[index][sum] = (include || exclude) ? 1 : 0;
            }
        }

        return dp[0][0] == 1;
    }

    public static boolean solveUsingTabuSO(int[] nums, int target) {
        int n = nums.length;
        int curr[] = new int[target + 1];
        int next[] = new int[target + 1];

        curr[target] = 1;
        next[target] = 1;

        for (int index = n - 1; index >= 0; index--) {
            for (int sum = target; sum >= 0; sum--) {
                boolean include = false;
                if (sum + nums[index] <= target) {
                    include = next[sum + nums[index]] == 1;
                }
                boolean exclude = next[sum] == 1;
                curr[sum] = (include || exclude) ? 1 : 0;
            }
            next = curr.clone();
        }

        return next[0] == 1;
    }

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if ((totalSum & 1) == 1) {
            return false;
        }

        int target = totalSum / 2;
        // return solveUsingRec(nums, 0, 0, target);
        // Boolean dp[][] = new Boolean[nums.length + 1][target + 1];
        // for (Boolean[] row : dp) {
            // Arrays.fill(row, null);
        // }
        // return solveUsingMemo(nums, 0, 0, target, dp)
        return solveUsingTabuSO(nums, target);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 5, 11, 5 };
        System.out.println(canPartition(nums1));
        int nums2[] = { 1, 2, 3, 5 };
        System.out.println(canPartition(nums2));
    }
}
