import java.util.Arrays;

public class LongestConsecutiveSequenceBetterApproach {
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        // Sort the array to bring consecutive numbers together
        Arrays.sort(nums);

        // Variable to track the last smaller element in sequence
        int lastSmaller = Integer.MIN_VALUE;

        // Variable to store the current sequence length
        int cnt = 0;

        // Variable to store the longest sequence length found
        int longest = 1;

        // Iterate through the sorted array
        for (int i = 0; i < n; i++) {
            // Case 1: Current element is exactly one greater than lastSmaller → part of sequence
            if (nums[i] - 1 == lastSmaller) {
                // Increment the sequence length
                cnt += 1;
                // Update the last smaller element
                lastSmaller = nums[i];
            }
            // Case 2: Current element is not consecutive and not a duplicate
            else if (nums[i] != lastSmaller) {
                // Reset the sequence length count to 1
                cnt = 1;
                // Update the last smaller element
                lastSmaller = nums[i];
            }
            // Update the longest sequence length if the current sequence is longer
            longest = Math.max(longest, cnt);
        }

        // Return the length of the longest consecutive sequence
        return longest;
    }

    public static void main(String[] args) {
        int nums1[] = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums1));
        int nums2[] = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutive(nums2));
        int nums3[] = { 1, 0, 1, 2 };
        System.out.println(longestConsecutive(nums3));
    }
}
