public class FindTheSmallestDivisorGivenAThreshold {
    public static int calculateSum(int[] nums, int divisor) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] + divisor - 1) / divisor;
        }

        return sum;
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int s = 1;
        int e = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            e = Math.max(nums[i], e);
        }
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            int sum = calculateSum(nums, mid);
            if (sum <= threshold) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 5, 9 };
        System.out.println(smallestDivisor(nums1, 6));
        int nums2[] = { 44, 22, 33, 11, 1 };
        System.out.println(smallestDivisor(nums2, 5));
    }
}
