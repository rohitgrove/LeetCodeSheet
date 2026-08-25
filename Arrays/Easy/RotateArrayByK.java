public class RotateArrayByK {
    public static void bruteForce(int nums[], int k) {
        k = k % nums.length;

        for (int i = 1; i <= k; i++) {
            int num = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }

            nums[0] = num;
        }
    }

    public static void optimizedApproach(int nums[], int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
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

    public static void main(String args[]) {
        int nums1[] = { 1, 2, 3, 4, 5, 6, 7 };
        rotate(nums1, 3);
        printArr(nums1);
        int nums2[] = { -1, -100, 3, 99 };
        rotate(nums2, 2);
        printArr(nums2);
    }
}