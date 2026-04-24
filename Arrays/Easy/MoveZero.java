public class MoveZero {
    public static void moveZeroesBruteForce(int[] nums) {
        int res[] = new int[nums.length];

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res[j] = nums[i];
                j++;
            }
        }

        for (int i = 0; i < res.length; i++) {
            nums[i] = res[i];
        }
    }

    public static void moveZeroesOptimized(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void moveZeroes(int[] nums) {
        moveZeroesOptimized(nums);
    }

    public static void printArr(int nums[]) {
        for (int ele : nums) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 0, 1, 0, 3, 12 };
        moveZeroes(nums1);
        printArr(nums1);
        int nums2[] = { 0, 1, 0, 2, 0, 3, 4 };
        moveZeroes(nums2);
        printArr(nums2);
    }
}
