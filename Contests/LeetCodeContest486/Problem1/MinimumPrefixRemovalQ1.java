public class MinimumPrefixRemovalQ1 {
    public static int minimumPrefixLength(int[] nums) {
        int n = nums.length;

        int idx = n - 1;

        while (idx > 0 && nums[idx - 1] < nums[idx]) {
            idx--;
        }

        return idx;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, -1, 2, 3, 3, 4, 5 };
        System.out.println(minimumPrefixLength(nums1));
        int nums2[] = { 4, 3, -2, -5 };
        System.out.println(minimumPrefixLength(nums2));
        int nums3[] = { 1, 2, 3, 4 };
        System.out.println(minimumPrefixLength(nums3));
    }
}
