public class MaximumSubArray {
    public static int maxSubArray(int[] nums) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i];
            if (ans > max) {
                max = ans;
            }

            if (ans < 0) {
                ans = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int nums1[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums1));
        int nums2[] = { 5, 4, -1, 7, 8 };
        System.out.println(maxSubArray(nums2));
    }
}
