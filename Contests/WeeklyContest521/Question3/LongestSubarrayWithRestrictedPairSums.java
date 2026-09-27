public class LongestSubarrayWithRestrictedPairSums {
    public static int maxSubarray(int[] nums) {
        int[] freq = new int[501];
        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            int x = nums[right];

            while (createsInvalidTriple(freq, x)) {
                freq[nums[left]]--;
                left++;
            }

            freq[x]++;
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static boolean createsInvalidTriple(int[] freq, int x) {
        for (int y = 1; y <= 500 - x; y++) {
            if (freq[y] > 0 && freq[x + y] > 0) {
                return true;
            }
        }

        for (int y = 1; y < x; y++) {
            int z = x - y;

            if (freq[y] > 0 && freq[z] > 0) {
                if (y != z || freq[y] >= 2) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 5, 3, 2, 1 };
        System.out.println(maxSubarray(nums1));
        int[] nums2 = { 3, 4, 5, 6 };
        System.out.println(maxSubarray(nums2));
    }
}