public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    public static void printArr(int nums[], int size) {
        System.out.println("Size Of Array: " + size);
        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 2 };
        printArr(nums1, removeDuplicates(nums1));
        int nums2[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        printArr(nums2, removeDuplicates(nums2));
    }
}
