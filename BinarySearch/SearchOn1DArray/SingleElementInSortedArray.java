public class SingleElementInSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (start == end) {
                return nums[start];
            }

            if ((mid & 1) == 1) {
                if (mid >= 0 && nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                    start = mid + 2;
                } else {
                    end = mid;
                }
            }

            mid = start + (end - start) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println(singleNonDuplicate(nums1));
        int nums2[] = { 3, 3, 7, 7, 10, 11, 11 };
        System.out.println(singleNonDuplicate(nums2));
    }
}
