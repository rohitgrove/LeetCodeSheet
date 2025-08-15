public class SingleElementInAnArray {
    public static int singleNonDuplicate(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (s == e) {
                return nums[s];
            }

            if ((mid & 1) == 1) {
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else {
                if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                    s = mid + 2;
                } else {
                    e = mid;
                }
            }
            mid = s + (e - s) / 2;
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
