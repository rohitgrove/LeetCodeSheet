public class FindLastAndFirstPostionInSortedArray {
    public static int firstOccerence(int nums[], int target) {
        int s = 0;
        int e = nums.length - 1;
        int ans = -1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (nums[mid] == target) {
                ans = mid;
                e = mid - 1;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static int lastOccerence(int nums[], int target) {
        int s = 0;
        int e = nums.length - 1;
        int ans = -1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (nums[mid] == target) {
                ans = mid;
                s = mid + 1;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        int res[] = { firstOccerence(nums, target), lastOccerence(nums, target) };
        return res;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 7, 7, 8, 8, 10 };
        int res[] = searchRange(nums, 8);
        System.out.println("First and Last Positions: " + res[0] + " " + res[1]);
    }
}
