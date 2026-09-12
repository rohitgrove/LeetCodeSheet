import java.util.Arrays;

public class CountSubarraysWithDistantSums {
    public static long distantSubarrays(int[] nums, int goal, int k) {
        int n = nums.length;
        if (k == 0) {
            return (long) n * (n + 1) / 2;
        }

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long low = (long) goal - k + 1;
        long high = (long) goal + k - 1;

        long[] sorted = prefix.clone();
        Arrays.sort(sorted);

        int m = 0;

        for (int i = 0; i < sorted.length; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                sorted[m++] = sorted[i];
            }
        }

        Fenwick fenwick = new Fenwick(m);

        long nonDistant = 0;

        for (int j = 0; j <= n; j++) {
            long current = prefix[j];
            long left = current - high;
            long right = current - low;
            long countRight = fenwick.query(upperBound(sorted, m, right));
            long countLeft = fenwick.query(lowerBound(sorted, m, left));

            nonDistant += countRight - countLeft;
            int index = lowerBound(sorted, m, current);
            fenwick.add(index + 1, 1);
        }

        long total = (long) n * (n + 1) / 2;

        return total - nonDistant;
    }

    public static int lowerBound(long[] arr, int size, long target) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int upperBound(long[] arr, int size, long target) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 1 };
        System.out.println(distantSubarrays(nums1, 4, 1));
        int nums2[] = { 2, -1, 3 };
        System.out.println(distantSubarrays(nums2, 2, 2));
        int nums3[] = { -3, 1, 2 };
        System.out.println(distantSubarrays(nums3, 0, 3));
    }
}
