public class FindOutHowManyTimesTheArrayHasBeenRotated {
    public static int findRotations(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (s == e) {
                return (s) + 1;
            }
            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return (mid) + 1;
            } else if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return (mid - 1) + 1;
            } else if (nums[s] > nums[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr1[] = { 4, 5, 6, 7, 0, 1, 2, 3 };
        System.out.println(findRotations(arr1));
        int arr2[] = { 3, 4, 5, 1, 2 };
        System.out.println(findRotations(arr2));
    }
}
