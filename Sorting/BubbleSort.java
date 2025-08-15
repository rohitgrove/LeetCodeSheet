public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 5, 4, 3, 2, 1 };
        bubbleSort(nums1);
        printArr(nums1);
        int nums2[] = { 10, 1, 7, 6, 14, 9 };
        bubbleSort(nums2);
        printArr(nums2);
        int nums3[] = { 34, 8, 64, 51, 32, 21 };
        bubbleSort(nums3);
        printArr(nums3);
        int nums4[] = { 44, 33, 55, 22, 11 };
        bubbleSort(nums4);
        printArr(nums4);
        int nums5[] = { 34, 8, 64, 51, 32, 21 };
        bubbleSort(nums5);
        printArr(nums5);
    }
}
