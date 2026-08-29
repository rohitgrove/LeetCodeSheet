public class LongestConsecutiveSequenceBruteForce {
    public static boolean linearSearch(int[] nums, int num) {
        // Get length of the array
        int n = nums.length;
        // Traverse through the array to check if the number exists
        for (int i = 0; i < n; i++) {
            // If element matches the number, return true
            if (nums[i] == num) {
                return true;
            }
        }
        // Number not found
        return false;
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            // Store the current number
            int num = nums[i];
            // Start sequence length count from 1
            int cnt = 1;
            while (linearSearch(nums, num + 1) == true) {
                // Move to the next consecutive number
                num += 1;
                // Increase the count of the current sequence
                cnt += 1;
            }

            maxLen = Math.max(cnt, maxLen);
        }

        return maxLen;
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
