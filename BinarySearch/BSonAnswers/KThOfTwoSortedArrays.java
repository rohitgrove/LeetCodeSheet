public class KThOfTwoSortedArrays {
    public static int kthElement(int nums1[], int nums2[], int k) {
        int n = nums1.length + nums2.length;
        int ans[] = new int[n];

        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] < nums2[idx2]) {
                ans[idx3] = nums1[idx1];
                idx3++;
                idx1++;
            } else {
                ans[idx3] = nums2[idx2];
                idx3++;
                idx2++;
            }
        }

        while (idx1 < nums1.length) {
            ans[idx3] = nums1[idx1];
            idx3++;
            idx1++;
        }

        while (idx2 < nums2.length) {
            ans[idx3] = nums2[idx2];
            idx3++;
            idx2++;
        }

        return ans[k - 1];
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 3, 6, 7, 9 }, nums2[] = { 1, 4, 8, 10 };
        System.out.println(kthElement(nums1, nums2, 5));
        int nums3[] = { 1, 4, 8, 10, 12 }, nums4[] = { 5, 7, 11, 15, 17 };
        System.out.println(kthElement(nums3, nums4, 6));
    }
}
