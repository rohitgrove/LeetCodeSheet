public class SplitArrayLargestSum {
    public static boolean isPossible(int[] nums, int mid, int k) {
        int subArray = 1;
        int sizeOfSubArray = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sizeOfSubArray + nums[i] <= mid) {
                sizeOfSubArray += nums[i];
            } else {
                subArray++;
                if (subArray > k || nums[i] > mid) {
                    return false;
                }
                sizeOfSubArray = 0;
                sizeOfSubArray += nums[i];
            }
        }

        return true;
    }

    public static int splitArray(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            end += nums[i];
        }

        int ans = -1;
        int mid = start + (end - start) / 2;
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

    public static void main(String[] args) {
        int nums1[] = { 7, 2, 5, 10, 8 };
        System.out.println(splitArray(nums1, 2));
        int nums2[] = { 1, 2, 3, 4, 5 };
        System.out.println(splitArray(nums2, 2));
    }
}
