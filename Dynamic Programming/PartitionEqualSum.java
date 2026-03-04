public class PartitionEqualSum {
    public static boolean solveUsingRec(int nums[], int idx, int currSum, int target) {
        if (idx >= nums.length) {
            return false;
        }

        if (currSum > target) {
            return false;
        }

        if (currSum == target) {
            return true;
        }

        boolean include = solveUsingRec(nums, idx + 1, currSum + nums[idx], target);
        boolean exclude = solveUsingRec(nums, idx + 1, currSum, target);

        return include || exclude;
    }

    public static boolean solveUsingMemo(int nums[], int idx, int currSum, int target, int dp[][]) {
        if (idx >= nums.length) {
            return false;
        }

        if (currSum > target) {
            return false;
        }

        if (currSum == target) {
            return true;
        }

        if (dp[idx][currSum] != -1) {
            return dp[idx][currSum] == 1;
        }

        boolean include = solveUsingMemo(nums, idx + 1, currSum + nums[idx], target, dp);
        boolean exclude = solveUsingMemo(nums, idx + 1, currSum, target, dp);

        dp[idx][currSum] = include || exclude ? 1 : 0;
        return include || exclude;
    }

    public static boolean solveUsingTabu(int nums[], int target) {
        int n = nums.length;
        int dp[][] = new int[n + 2][target + 1];

        for (int row = 0; row <= n; row++) {
            dp[row][target] = 1;
        }

        for (int index = n - 1; index >= 0; index--) {
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

    public static boolean solveUsingTabulationSO(int[] nums, int target) {
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
        // int index = 0;
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if ((totalSum & 1) == 1) {
            // odd cannot be partioned
            return false;
        }
        int target = totalSum / 2;
        // int currSum = 0;
        // boolean ans = solveUsingRecursion(nums, index, currSum, target);
        // int dp[][] = new int[nums.length + 1][target + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // boolean ans = solveUsingMemo(nums, index, currSum, target, dp);
        boolean ans = solveUsingTabulationSO(nums, target);
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 5, 11, 5 };
        System.out.println(canPartition(nums1));
        int nums2[] = { 1, 2, 3, 5 };
        System.out.println(canPartition(nums2));
    }
}
