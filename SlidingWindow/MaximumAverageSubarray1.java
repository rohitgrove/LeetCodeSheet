public class MaximumAverageSubarray1 {
    public static double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        maxSum = Math.max(sum, maxSum);

        int start = 0;
        int end = k;
        while (end < nums.length) {
            sum -= nums[start];
            sum += nums[end];
            maxSum = Math.max(sum, maxSum);
            start++;
            end++;

        }

        double maxAvg = ((double) maxSum) / k;

        return maxAvg;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 12, -5, -6, 50, 3 }, k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
