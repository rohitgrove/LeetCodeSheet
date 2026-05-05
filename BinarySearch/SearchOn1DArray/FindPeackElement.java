public class FindPeackElement {
    public static int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
                s = mid + 1;
            } else if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                e = mid - 1;
            } else {
                ans = mid;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 1 };
        System.out.println(findPeakElement(nums1));
        int nums2[] = { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println(findPeakElement(nums2));
    }
}
