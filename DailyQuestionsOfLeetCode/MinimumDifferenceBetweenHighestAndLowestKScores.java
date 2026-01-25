import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestKScores {
    public static int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int currentDiff = nums[i + k - 1] - nums[i];
            minDiff = Math.min(minDiff, currentDiff);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int nums[] = { 9, 4, 1, 7 }, k = 2;
        System.out.println(minimumDifference(nums, k));
    }
}
