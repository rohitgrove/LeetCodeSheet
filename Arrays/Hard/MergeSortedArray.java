public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;
        int ansIdx = m + n - 1;

        while (idx1 >= 0 && idx2 >=0) {
            if (nums1[idx1] > nums2[idx2]) {
                nums1[ansIdx] = nums1[idx1];
                idx1--;
            } else {
                nums1[ansIdx] = nums2[idx2];
                idx2--;
            }
            ansIdx--;
        }

        while (idx2 >= 0) {
            nums1[ansIdx] = nums2[idx2];
            idx2--;
            ansIdx--;
        }
    }

    public static void printArr(int ans[]) {
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 0, 0, 0 };
        int nums2[] = { 2, 5, 6 };
        merge(nums1, 3, nums2, 3);
        printArr(nums1);
    }
}
