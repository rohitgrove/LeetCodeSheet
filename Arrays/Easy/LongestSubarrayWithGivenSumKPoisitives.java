public class LongestSubarrayWithGivenSumKPoisitives {
    public static int longestSubarrayBruteForce(int nums[], int k) {
        int maxLen = 0;

        for (int startIndex = 0; startIndex < nums.length; startIndex++) {
            for (int endIndex = startIndex; endIndex < nums.length; endIndex++) {
                int sum = 0;

                for (int i = startIndex; i <= endIndex; i++) {
                    sum += nums[i];
                }

                if (sum == k) {
                    maxLen = Math.max(maxLen, endIndex - startIndex + 1);
                }
            }
        }

        return maxLen;
    }

    public static int longestSubarrayOptimizedApproach(int nums[], int k) {
        int maxLength = 0;

        int left = 0, right = 0;
        int sum = 0;

        while (right < nums.length) {
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            sum += nums[right];
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 5, 2, 7, 1, 9 };
        System.out.println(longestSubarrayBruteForce(nums1, 15));
        int nums2[] = { -3, 2, 1 };
        System.out.println(longestSubarrayBruteForce(nums2, 6));
    }
}
