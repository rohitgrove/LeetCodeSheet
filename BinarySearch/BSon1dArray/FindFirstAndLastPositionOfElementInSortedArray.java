public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int findLastOccerence(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        int mid = start + (end - start) / 2;
        int ans = -1;

        while (start <= end) {
            if (arr[mid] == target) {
                ans = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        return ans;
    }

    public static int findFirstOccerence(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        int mid = start + (end - start) / 2;
        int ans = -1;

        while (start <= end) {
            if (arr[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstOccur = findFirstOccerence(nums, target);
        int lastOccur = findLastOccerence(nums, target);

        return new int[] { firstOccur, lastOccur };
    }

    public static void printAns(int ans[]) {
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static void main(String[] args) {
        int nums[] = { 5, 7, 7, 8, 8, 10 };
        printAns(searchRange(nums, 8));
        printAns(searchRange(nums, 6));
    }
}
