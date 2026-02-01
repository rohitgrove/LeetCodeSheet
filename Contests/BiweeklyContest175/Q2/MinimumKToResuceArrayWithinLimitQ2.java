public class MinimumKToResuceArrayWithinLimitQ2 {
    public static boolean canMake(int[] nums, int k) {
        long ops = 0;
        long limit = (long) k * k;

        for (int x : nums) {
            ops += (x + k - 1) / k; // ceil(x/k)
            if (ops > limit)
                return false;
        }
        return true;
    }

    public static int minimumK(int[] nums) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int left = 1;
        int right = Math.max(max, nums.length);
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canMake(nums, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 7, 5 };
        System.out.println(minimumK(nums1));
        int nums2[] = { 1 };
        System.out.println(minimumK(nums2));
    }
}
