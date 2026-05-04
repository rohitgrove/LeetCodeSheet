public class BinarySearch {
    public static int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums1[] = { -1, 0, 3, 5, 9, 12 };
        System.out.println(search(nums1, 9));
        System.out.println(search(nums1, 2));
        int nums2[] = { 10, 20, 30, 40, 50, 60, 70, 80 };
        System.out.println(search(nums2, 70));
        System.out.println(search(nums2, 75));
    }
}
