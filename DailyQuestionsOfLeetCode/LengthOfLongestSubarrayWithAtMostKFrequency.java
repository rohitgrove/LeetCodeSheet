import java.util.HashMap;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public static int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        int maxLen = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            // Current element ki frequency increase karo
            countMap.put(nums[end], countMap.getOrDefault(nums[end], 0) + 1);

            // Agar current element ki frequency k se zyada ho gayi
            while (countMap.get(nums[end]) > k) {
                countMap.put(nums[start], countMap.get(nums[start]) - 1);
                start++;
            }

            // Ab [start ... end] good subarray hai
            int len = end - start + 1;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 1, 2, 3, 1, 2 };
        System.out.println(maxSubarrayLength(nums1, 2)); // 6

        int[] nums2 = { 1, 2, 1, 2, 1, 2, 1, 2 };
        System.out.println(maxSubarrayLength(nums2, 1)); // 2

        int[] nums3 = { 5, 5, 5, 5, 5, 5, 5 };
        System.out.println(maxSubarrayLength(nums3, 4)); // 4
    }
}