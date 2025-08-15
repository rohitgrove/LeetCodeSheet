public class FindMinimumInRotatedSortedArray2 {
    public static int findMin(int[] nums) {
        int st = 0;
        int ed = nums.length - 1;

        int mid = st + (ed - st) / 2;
        while (st < ed) {
            if (nums[mid] < nums[ed]) {
                ed = mid;
            } else if (nums[mid] > nums[ed]) {
                st = mid + 1;
            } else {
                ed--;
            }

            mid = st + (ed - st) / 2;
        }

        return nums[st];
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, 5 };
        System.out.println(findMin(nums1));
        int nums2[] = { 2, 2, 2, 0, 1 };
        System.out.println(findMin(nums2));
    }
}
