public class CountGoodCyclicRotations {
    public static int countGoodRotations(int[] nums) {
        int n = nums.length;
        int half = n / 2;

        long total = 0;

        for (int num : nums) {
            total += num;
        }

        long sum = 0;

        for (int i = 0; i < half; i++) {
            sum += nums[i];
        }

        int count = 0;

        for (int start = 0; start < n; start++) {
            if (total < (2 * sum)) {
                count++;
            }

            int removeIndex = start;
            int addIndex = (start + half) % n;

            sum -= nums[removeIndex];
            sum += nums[addIndex];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5, 6 };
        System.out.println(countGoodRotations(nums1));
        // Output: 3

        int[] nums2 = { 1, 2, 1, 2 };
        System.out.println(countGoodRotations(nums2));
        // Output: 0

        int[] nums3 = { 1, 1, 1, 1 };
        System.out.println(countGoodRotations(nums3));
        // Output: 0

        int[] nums4 = { 10, 1, 1, 1 };
        System.out.println(countGoodRotations(nums4));
        // Output: 2

        int[] nums5 = { 5, 5, 1, 1 };
        System.out.println(countGoodRotations(nums5));
        // Output: 2
    }
}
