public class FindMinimumInRotatedSortedArray {
    public static int findMin(int nums[]) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            if (nums[start] <= nums[end]) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 4, 5, 1, 2 };
        System.out.println(findMin(nums1));
        int nums2[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(nums2));
        int nums3[] = { 11, 13, 15, 17 };
        System.out.println(findMin(nums3));
    }
}
