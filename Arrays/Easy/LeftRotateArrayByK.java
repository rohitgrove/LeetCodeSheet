public class LeftRotateArrayByK {
    public static void bruteForce(int nums[], int k) {
        k = k % nums.length;

        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int idx = nums.length - 1; idx >= 1; idx--) {
                nums[idx] = nums[idx - 1];
            }
            nums[0] = temp;
        }
    }

    public static void rotate(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void optimizedApproach(int nums[], int k) {
        k = k % nums.length;

        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    public static void rotate(int[] nums, int k) {
        optimizedApproach(nums, k);
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        rotate(nums, 3);
        printArr(nums);
    }
}
