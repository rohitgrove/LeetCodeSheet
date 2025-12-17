public class HouseRobber {
    public static int solveUsingRec(int nums[], int idx) {
        if (idx >= nums.length) {
            return 0;
        }

        int inc = nums[idx] + solveUsingRec(nums, idx + 2);
        int exc = solveUsingRec(nums, idx + 1);
        return Math.max(inc, exc);
    }

    public static int solveUsingMemo(int nums[], int idx, int dp[]) {
        if (idx >= nums.length) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int inc = nums[idx] + solveUsingMemo(nums, idx + 2, dp);
        int exc = solveUsingMemo(nums, idx + 1, dp);
        dp[idx] = Math.max(inc, exc);
        return dp[idx];
    }

    public static int solveUsingTabu(int nums[]) {
        int dp[] = new int[nums.length + 1];

        for (int idx = nums.length - 1; idx >= 0; idx--) {
            int num = idx + 2 < nums.length - 1 ? dp[idx + 2] : 0;
            int inc = nums[idx] + num;
            int exc = dp[idx + 1];
            dp[idx] = Math.max(inc, exc);
        }

        return dp[0];
    }

    public static int solveUsingTabuSO(int nums[]) {
        int n = nums.length;

        int prev = nums[n - 1];
        int next = 0;
        int curr;

        for (int index = n - 2; index >= 0; index--) {
            int tempAns = 0;
            if (index + 2 < n) {
                tempAns = next;
            }
            int include = nums[index] + tempAns;
            int exclude = prev;
            curr = Math.max(include, exclude);
            // bhul jata hu
            next = prev;
            prev = curr;
        }

        return prev;
    }

    public static int rob(int[] nums) {
        // return solveUsingRec(nums, 0);
        // int dp[] = new int[nums.length + 1];
        // Arrays.fill(dp, -1);
        // return solveUsingMemo(nums, 0, dp);
        return solveUsingTabuSO(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 1 };
        System.out.println(rob(nums1));
        int nums2[] = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums2));
    }
}
