public class LongestStrictlyIncreasingSubsequenceWithNonZeroBitwiseANDQ3 {
    public static int longestSubsequence(int[] nums) {
        int ans = 0;

        // check for each bit
        for (int bit = 0; bit <= 30; bit++) {
            int mask = 1 << bit;

            // patience sorting array
            int[] lis = new int[nums.length];
            int len = 0;

            for (int x : nums) {
                if ((x & mask) == 0) continue; // bit not present

                // binary search in lis[0..len)
                int l = 0, r = len;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (lis[mid] < x) l = mid + 1;
                    else r = mid;
                }

                lis[l] = x;
                if (l == len) len++;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }


    public static void main(String[] args) {
        int nums1[] = { 5, 4, 7 };
        System.out.println(longestSubsequence(nums1));
        int nums2[] = { 2, 3, 6 };
        System.out.println(longestSubsequence(nums2));
    }
}
