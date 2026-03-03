import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int solveUsingRec(int[] nums, int curr, int prev) {
        if (curr >= nums.length) {
            return 0;
        }

        int include = 0;
        if (prev == -1 || nums[curr] > nums[prev]) {
            include = 1 + solveUsingRec(nums, curr + 1, curr);
        }
        int exclude = solveUsingRec(nums, curr + 1, prev);
        return Math.max(include, exclude);
    }

    public static int solveUsingMemo(int[] nums, int curr, int prev, int dp[][]) {
        if (curr >= nums.length) {
            return 0;
        }

        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        int include = 0;
        if (prev == -1 || nums[curr] > nums[prev]) {
            include = 1 + solveUsingMemo(nums, curr + 1, curr, dp);
        }
        int exclude = solveUsingMemo(nums, curr + 1, prev, dp);
        dp[curr][prev + 1] = Math.max(include, exclude);
        return dp[curr][prev + 1];
    }

    public static int solveUsingTabulation(int[] nums) {
        int dp[][] = new int[nums.length + 1][nums.length + 1];

        for (int curr_index = nums.length - 1; curr_index >= 0; curr_index--) {
            for (int prev_index = curr_index - 1; prev_index >= -1; prev_index--) {
                int include = 0;
                if (prev_index == -1 || nums[curr_index] > nums[prev_index]) {
                    include = 1 + dp[curr_index + 1][curr_index + 1];
                }
                int exclude = dp[curr_index + 1][prev_index + 1];
                dp[curr_index][prev_index + 1] = Math.max(include, exclude);
            }
        }

        return dp[0][0];
    }

    public static int solveUsingTabulationSO(int[] nums) {
        int nextRow[] = new int[nums.length + 1];
        int currRow[] = new int[nums.length + 1];

        for (int curr_index = nums.length - 1; curr_index >= 0; curr_index--) {
            for (int prev_index = curr_index - 1; prev_index >= -1; prev_index--) {
                int include = 0;
                if (prev_index == -1 || nums[curr_index] > nums[prev_index]) {
                    include = 1 + nextRow[curr_index + 1];
                }
                int exclude = nextRow[prev_index + 1];
                currRow[prev_index + 1] = Math.max(include, exclude);
            }
            nextRow = currRow.clone();
        }

        return currRow[0];
    }

    public static int solveUsingBS(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        ans.addLast(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > ans.getLast()) {
                ans.addLast(nums[i]);
            } else {
                int index = Collections.binarySearch(ans, nums[i]);
                if (index < 0) {
                    index = -(index + 1);
                }
                ans.set(index, nums[i]);
            }
        }

        return ans.size();
    }

    public static int lengthOfLIS(int[] nums) {
        // int curr = 0;
        // int prev = -1;
        // int ans = solveUsingRec(nums, curr, prev);
        // int dp[][] = new int[nums.length + 1][nums.length + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // int ans = solveUsingMemo(nums, curr, prev, dp);
        int ans = solveUsingBS(nums);
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums1));
        int nums2[] = { 0, 1, 0, 3, 2, 3 };
        System.out.println(lengthOfLIS(nums2));
        int nums3[] = { 7, 7, 7, 7, 7, 7, 7 };
        System.out.println(lengthOfLIS(nums3));
    }
}
