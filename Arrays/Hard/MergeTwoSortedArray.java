public class MergeTwoSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = (m + n) - 1;
        int j = m - 1;
        int i = n - 1;

        while (j >= 0 && i >= 0) {
            if (nums1[j] > nums2[i]) {
                nums1[idx] = nums1[j];
                j--;
            } else {
                nums1[idx] = nums2[i];
                i--;
            }
            idx--;
        }

        while (i >= 0) {
            nums1[idx] = nums2[i];
            i--;
            idx--;
        }
    }

    public static void printArr(int arr[]) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 0, 0, 0 }, m = 3, nums2[] = { 2, 5, 6 }, n = 3;
        merge(nums1, m, nums2, n);
        printArr(nums1);
    }
}
