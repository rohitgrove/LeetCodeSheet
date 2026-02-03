public class TrionicArray1 {
    public static boolean isTrionic(int[] nums) {
        int n = nums.length;

        int idx = 0;

        // Increasing
        while (idx + 1 < n && nums[idx] < nums[idx + 1]) {
            idx++;
        }

        if (idx == 0 || idx == n - 1) {
            return false;
        }

        // Decreasing
        while (idx + 1 < n && nums[idx] > nums[idx + 1]) {
            idx++;
        }

        if (idx == n - 1) {
            return false;
        }

        // Increasing
        while (idx + 1 < n && nums[idx] < nums[idx + 1]) {
            idx++;
        }

        return idx == n - 1;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, 5, 4, 2, 6 };
        System.out.println(isTrionic(nums1));
        int nums2[] = { 2, 1, 3 };
        System.out.println(isTrionic(nums2));
    }
}
