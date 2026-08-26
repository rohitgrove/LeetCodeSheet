public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int len = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                len += nums[i];
                maxLen = Math.max(len, maxLen);
            } else {
                len = 0;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 0, 1, 1, 1 };
        System.out.println(findMaxConsecutiveOnes(nums1));
        int nums2[] = { 1, 0, 1, 1, 0, 1 };
        System.out.println(findMaxConsecutiveOnes(nums2));
    }
}
