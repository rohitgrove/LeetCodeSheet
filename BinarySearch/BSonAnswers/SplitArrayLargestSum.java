public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            end += nums[i];
        }

        int mid = start + (end - start) / 2;
        int ans = -1;
        while (start <= end) {
            if (isPossible(nums, mid, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }

        return ans;
    }

    public static boolean isPossible(int[] nums, int mid, int k) {
        int count = 0;
        int subArray = 1;

        for (int i = 0; i < nums.length; i++) {
            if (count + nums[i] <= mid) {
                count += nums[i];
            } else {
                subArray++;
                if (subArray > k || nums[i] > mid) {
                    return false;
                }
                count = 0;
                count += nums[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int nums1[] = { 7, 2, 5, 10, 8 };
        System.out.println(splitArray(nums1, 2));
        int nums2[] = { 1, 2, 3, 4, 5 };
        System.out.println(splitArray(nums2, 2));
    }
}
