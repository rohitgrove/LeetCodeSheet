public class RunningSumOf1dArray {
    public static int[] runningSum(int[] nums) {
        int sum = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            sum += nums[idx];
            nums[idx] = sum;
        }

        return nums;
    }

    public static void printArr(int nums[]) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 4 };
        printArr(runningSum(nums1));
        int nums2[] = { 1, 1, 1, 1, 1 };
        printArr(runningSum(nums2));
        int nums3[] = { 3, 1, 2, 10, 1 };
        printArr(runningSum(nums3));
    }
}
