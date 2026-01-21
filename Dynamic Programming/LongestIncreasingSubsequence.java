import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int solveUsingRec(int nums[], int curr, int prev) {
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

    public static int solveUsingMemo(int nums[], int curr, int prev, int dp[][]) {
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

    public static int solveUsingTabu(int nums[]) {
        int dp[][] = new int[nums.length + 1][nums.length + 1];

        for (int curr = nums.length - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {
                int include = 0;
                if (prev == -1 || nums[curr] > nums[prev]) {
                    include = 1 + dp[curr + 1][curr + 1];
                }

                int exclude = dp[curr + 1][prev + 1];
                dp[curr][prev + 1] = Math.max(include, exclude);
            }
        }

        return dp[0][0];
    }

    public static int solveUsingTabuSO(int nums[]) {
        int currRow[] = new int[nums.length + 1];
        int nextRow[] = new int[nums.length + 1];

        for (int curr = nums.length - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {
                int include = 0;
                if (prev == -1 || nums[curr] > nums[prev]) {
                    include = 1 + nextRow[curr + 1];
                }

                int exclude = nextRow[prev + 1];
                currRow[prev + 1] = Math.max(include, exclude);
            }
            nextRow = currRow.clone();
        }

        return nextRow[0];
    }

    public static int solveUsingBS(int nums[]) {
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
        // return solveUsingRec(nums, 0, -1);
        // int dp[][] = new int[nums.length + 1][nums.length + 2];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        // return solveUsingMemo(nums, 0, -1, dp);

        return solveUsingBS(nums);
    }

    public static void main(String[] args) {
        int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));
    }
}
