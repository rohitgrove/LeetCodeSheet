public class SubarrayProductLessThank {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int left = 0, right = 0, product = 1, count = 0;
        int n = nums.length;

        while (right < n) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count += 1 + (right - left);
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 5, 2, 6 };
        System.out.println(numSubarrayProductLessThanK(nums1, 100));
        int nums2[] = { 1, 2, 3 };
        System.out.println(numSubarrayProductLessThanK(nums2, 0));
    }
}
