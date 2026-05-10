public class KthElementIn2SortedArray {
    public static int kthElement(int[] a, int[] b, int k) {
        int m = a.length;
        int n = b.length;

        // Ensure 'a' is the smaller array for optimization
        if (m > n) {
            return kthElement(b, a, k);
        }

        int left = k; // Number of elements in the left partition
        int low = Math.max(0, k - n), high = Math.min(k, m);

        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;

            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < m) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1; // Move left
            } else {
                low = mid1 + 1; // Move right
            }
        }

        return -1; // Should never reach here if inputs are valid
    }

    public static void main(String[] args) {
        int a1[] = { 2, 3, 6, 7, 9 }, b1[] = { 1, 4, 8, 10 }, k1 = 5;
        System.out.println(kthElement(a1, b1, k1));
        int a2[] = { 100, 112, 256, 349, 770 }, b2[] = { 72, 86, 113, 119, 265, 445, 892 }, k2 = 7;
        System.out.println(kthElement(a2, b2, k2));
    }
}
