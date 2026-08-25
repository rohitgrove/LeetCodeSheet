public class LeftRotateArrayByOne {
    public static void rotateByOne(int nums[]) {
        int num = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            nums[0] = nums[i + 1];
        }
        nums[nums.length - 1] = num;
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 4, 5 };
        rotateByOne(nums1);
        printArr(nums1);
        int nums2[] = { -1, 0, 2, 3, 6 };
        rotateByOne(nums2);
        printArr(nums2);
    }
}
