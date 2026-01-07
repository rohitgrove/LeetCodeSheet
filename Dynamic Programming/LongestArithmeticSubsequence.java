public class LongestArithmeticSubsequence {
    public static int solveUsingRec(int nums[], int i, int diff) {
        if (i == nums.length) {
            return 0;
        }

        int res = 1;
        if (diff == -501) {
            for (int j = i + 1; j < nums.length; j++) {
                int take = 1 + solveUsingRec(nums, j, nums[j] - nums[i]);
                int notTake = solveUsingRec(nums, j, diff);
                res = Math.max(res, Math.max(take, notTake));
            }
        } else {
            for (int j = i + 1; j < nums.length; j++) {
                int take = 0;
                if (diff == nums[j] - nums[i]) {
                    take = 1 + solveUsingRec(nums, j, diff);
                }
                res = Math.max(res, take);
            }
        }
        return res;
    }

    public static int solveUsingMemo(int nums[], Integer dp[][], int i, int diff) {
        if (i == nums.length) {
            return 0;
        }
        if (dp[i][diff + 501] != null) {
            return dp[i][diff + 501];
        }
        int res = 1;
        if (diff == -501) {
            for (int j = i + 1; j < nums.length; j++) {
                int take = 1 + solveUsingMemo(nums, dp, j, nums[j] - nums[i]);
                int notTake = solveUsingMemo(nums, dp, j, diff);
                res = Math.max(res, Math.max(take, notTake));
            }
        } else {
            for (int j = i + 1; j < nums.length; j++) {
                int take = 0;
                if (diff == nums[j] - nums[i]) {
                    take = 1 + solveUsingMemo(nums, dp, j, diff);
                }
                res = Math.max(res, take);
            }
        }
        return dp[i][diff + 501] = res;
    }

    public static int solveUsingTabu(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        // dp[i][diff] = length of arithmetic subsequence ending at i with given diff
        int[][] dp = new int[n][1001];
        int ans = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + 500;

                dp[i][diff] = dp[j][diff] > 0 ? dp[j][diff] + 1 : 2;

                ans = Math.max(ans, dp[i][diff]);
            }
        }
        return ans;
    }

    public static int longestArithSeqLength(int[] nums) {
        // return solveUsingRec(nums, 0, -501);
        // Integer dp[][] = new Integer[nums.length + 1][1002];
        // return solveUsingMemo(nums, dp, 0, -501);
        return solveUsingTabu(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 6, 9, 12 };
        System.out.println(longestArithSeqLength(nums1));
        int nums2[] = { 9, 4, 7, 2, 10 };
        System.out.println(longestArithSeqLength(nums2));
        int nums3[] = { 20, 1, 15, 3, 10, 5, 8 };
        System.out.println(longestArithSeqLength(nums3));
    }
}
