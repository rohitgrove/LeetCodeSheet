public class MedianOfTwoSortedArray {
    public static double findMedianSortedArraysMergeApproach(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] new_arr = new int[n];

        int i = 0, j = 0, k = 0;

        while (i <= n1 && j <= n2) {
            if (i == n1) {
                while (j < n2) {
                    new_arr[k++] = nums2[j++];
                }
                break;
            } else if (j == n2) {
                while (i < n1) {
                    new_arr[k++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                new_arr[k++] = nums1[i++];
            } else {
                new_arr[k++] = nums2[j++];
            }
        }

        if (n % 2 == 0) {
            return (float) (new_arr[n / 2 - 1] + new_arr[n / 2]) / 2;
        } else {
            return new_arr[n / 2];
        }
    }

    public static double findMedianSortedArraysBinarySearchApproach(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        // Ensure nums1 is the smaller array for simplicity
        if (n1 > n2) {
            return findMedianSortedArraysBinarySearchApproach(nums2, nums1);
        }

        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2; // Calculate the left partition size
        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) >> 1; // Calculate mid index for nums1
            int mid2 = left - mid1; // Calculate mid index for nums2

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            // Determine values of l1, l2, r1, and r2
            if (mid1 < n1) {
                r1 = nums1[mid1];
            }
            if (mid2 < n2) {
                r2 = nums2[mid2];
            }
            if (mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            }
            if (mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }

            if (l1 <= r2 && l2 <= r1) {
                // The partition is correct, we found the median
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                }
            } else if (l1 > r2) {
                // Move towards the left side of nums1
                high = mid1 - 1;
            } else {
                // Move towards the right side of nums1
                low = mid1 + 1;
            }
        }

        return 0; // If the code reaches here, the input arrays were not sorted.
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3 }, nums2[] = { 2 };
        System.out.println(findMedianSortedArraysBinarySearchApproach(nums1, nums2));
        int nums3[] = { 1, 2 }, nums4[] = { 3, 4 };
        System.out.println(findMedianSortedArraysBinarySearchApproach(nums3, nums4));
    }
}
