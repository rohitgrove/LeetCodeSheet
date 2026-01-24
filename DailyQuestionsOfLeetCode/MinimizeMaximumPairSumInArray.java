import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int maxSum = Integer.MIN_VALUE;

        while (left < right) {
            int currSum = nums[left] + nums[right];
            maxSum = Math.max(currSum, maxSum);
            left++;
            right--;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 5, 2, 3 };
        System.out.println(minPairSum(nums1));
        int nums2[] = { 3, 5, 4, 2, 4, 6 };
        System.out.println(minPairSum(nums2));
    }
}
