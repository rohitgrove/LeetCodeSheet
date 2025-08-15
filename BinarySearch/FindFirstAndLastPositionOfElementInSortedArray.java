public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int findFirstOccur(int[] nums, int target) {
        int ans = -1;

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                ans = mid;
                e = mid - 1;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }

    public static int findLastOccur(int[] nums, int target) {
        int ans = -1;

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                ans = mid;
                s = mid + 1;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = findFirstOccur(nums, target);
        ans[1] = findLastOccur(nums, target);
        return ans;
    }

    public static void print(int nums[]) {
        System.out.println(nums[0] + " " + nums[1]);
    }

    public static void main(String[] args) {
        int nums[] = { 5, 7, 7, 8, 8, 10 }, target = 8;
        print(searchRange(nums, target));
        target = 6;
        print(searchRange(nums, target));
    }
}
