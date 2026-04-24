public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 1) {
                int len = j - i + 1;
                maxLen = Math.max(len, maxLen);
            } else {
                i = j + 1;
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
