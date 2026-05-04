public class CountOccurrences {
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

    public static int countFreq(int[] arr, int target) {
        int lastoccur = lastOccerence(arr, target);
        int firstoccur = firstOccerence(arr, target);
        if (lastoccur == -1 && firstoccur == -1) {
            return 0;
        }
        return lastoccur - firstoccur + 1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 2, 2, 3 };
        System.out.println(countFreq(arr, 2));
    }
}
