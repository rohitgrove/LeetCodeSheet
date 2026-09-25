public class MedianOfTwoSortedArrays {
    public static double twoPointer(int nums1[], int nums2[]) {
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

        int andidx = ans.length / 2;
        if (ans.length % 2 == 0) {
            double res = ((double) (ans[andidx - 1] + ans[andidx])) / 2;
            return res;
        } else {
            return ans[andidx];
        }
    }

    public static double binarySearch(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return binarySearch(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0, high = n1;

        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return binarySearch(nums1, nums2);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, 4, 7, 10, 12 };
        int nums2[] = { 2, 3, 6, 15 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
        int nums3[] = { 1, 3 };
        int nums4[] = { 2 };
        System.out.println(findMedianSortedArrays(nums3, nums4));
        int nums5[] = { 1, 2 };
        int nums6[] = { 3, 4 };
        System.out.println(findMedianSortedArrays(nums5, nums6));
    }
}
