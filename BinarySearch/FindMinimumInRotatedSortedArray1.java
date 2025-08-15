public class FindMinimumInRotatedSortedArray1 {
    public static int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            if (s == e) {
                return nums[s] == nums[nums.length - 1] ? nums[0] : nums[s];
            }
            int mid = s + (e - s) / 2;
            if (mid < nums.length && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[s] > nums[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
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
