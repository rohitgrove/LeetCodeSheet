public class CountDominantIndicesQ1 {
    public static int dominantIndices(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for (int x : nums) {
            totalSum += x;
        }

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            int rightSum = totalSum - prefixSum - nums[i];
            int rightCount = n - i - 1;

            if (nums[i] * rightCount > rightSum) {
                count++;
            }

            prefixSum += nums[i];
        }

        return count;
    }

    public static void main(String[] args) {
        int arr1[] = { 5, 4, 3 };
        System.out.println(dominantIndices(arr1));
        int arr2[] = { 4, 1, 2 };
        System.out.println(dominantIndices(arr2));
    }
}
