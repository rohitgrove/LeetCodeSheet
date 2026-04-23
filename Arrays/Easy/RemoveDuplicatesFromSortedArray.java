public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                j++;
                nums[j] = nums[i + 1];
            }
        }

        return j + 1;
    }

    public static void printArr(int nums[], int end) {
        for (int i = 0; i < end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 2 };
        int end1 = removeDuplicates(nums1);
        System.out.println("Index after remove duplicates: " + end1);
        printArr(nums1, end1);
        int nums2[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int end2 = removeDuplicates(nums2);
        System.out.println("Index after remove duplicates: " + end2);
        printArr(nums2, end2);
    }
}
