public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        int ans = nums.length;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (nums[mid] >= target) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }

            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 5, 6 };
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
    }
}
