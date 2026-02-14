public class HouseRobber5 {
    public static long rob(int[] nums, int[] colors) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        long[] dp = new long[n];

        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            long skip = dp[i - 1];
            long take;

            if (colors[i] != colors[i - 1]) {
                take = nums[i] + dp[i - 1];
            } else {
                take = nums[i] + (i >= 2 ? dp[i - 2] : 0);
            }

            dp[i] = Math.max(skip, take);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 4, 3, 5 };
        int[] colors1 = { 1, 1, 2, 2 };

        System.out.println("Example 1 Output: " + rob(nums1, colors1));

        int[] nums2 = { 3, 1, 2, 4 };
        int[] colors2 = { 2, 3, 2, 2 };

        System.out.println("Example 2 Output: " + rob(nums2, colors2));

        int[] nums3 = { 10, 1, 3, 9 };
        int[] colors3 = { 1, 1, 1, 2 };

        System.out.println("Example 3 Output: " + rob(nums3, colors3));
    }
}
