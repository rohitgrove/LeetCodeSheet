public class LongestSubarrayOf1AfterDeletingOneElement {
    public static int longestSubarray(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        int max = 0, count = 0;

        while (j < n) {
            if (nums[j] == 0) {
                count++;
            } while (count > 1) {
                if (nums[i] == 0) {
                    count--;
                }
                i++;
            }
            max = Math.max(max, j - i);
            j++;
        }

        return max;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 0, 1 };
        System.out.println(longestSubarray(nums1));
        int nums2[] = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        System.out.println(longestSubarray(nums2));
    }
}
