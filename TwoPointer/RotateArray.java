public class RotateArray {
    public static void bruteForce(int nums[], int k) {
        k = k % nums.length;

        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j >= 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public static void optimizedApproach(int nums[], int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int nums[], int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

    public static void rotate(int[] nums, int k) {
        optimizedApproach(nums, k);
    }

    public static void printArr(int nums[]) {
        for (int ele : nums) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7 }, k = 3;
        System.out.println("Before rotating");
        printArr(nums);
        rotate(nums, k);
        System.out.println("After rotating");
        printArr(nums);
    }
}
