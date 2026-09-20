public class MaximumPulseValueAfterOneSubarrayRotation {
    public static long maxValue(int[] nums) {
        int n = nums.length;

        long total = 0;
        long prefix = 0;
        long minEvenSum = Long.MAX_VALUE;

        long[] maxPrefix = { 0, Long.MIN_VALUE };

        for (int i = 0; i < n; i++) {
            long value = (i % 2 == 0) ? nums[i] : -((long) nums[i]);
            total += value;
            prefix += value;

            int parity = (i + 1) % 2;

            if (maxPrefix[parity] != Long.MIN_VALUE) {
                minEvenSum = Math.min(minEvenSum, prefix - maxPrefix[parity]);
            }

            maxPrefix[parity] = Math.max(maxPrefix[parity], prefix);
        }

        if (minEvenSum < 0) {
            total -= 2 * minEvenSum;
        }

        return total;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 5, 2 };
        int[] nums2 = { 6, 4, 3 };
        int[] nums3 = { 9, 7 };
        int[] nums4 = { 1 };
        int[] nums5 = { 5, 1, 10, 2 };
        int[] nums6 = { -1, -2, -3, -4 };

        System.out.println(maxValue(nums1));
        System.out.println(maxValue(nums2));
        System.out.println(maxValue(nums3));
        System.out.println(maxValue(nums4));
        System.out.println(maxValue(nums5));
        System.out.println(maxValue(nums6));
    }
}