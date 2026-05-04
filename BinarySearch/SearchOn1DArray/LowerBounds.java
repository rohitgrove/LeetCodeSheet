public class LowerBounds {
    public static int lowerBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        int mid = start + (end - start) / 2;
        int ans = arr.length;

        while (start <= end) {
            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 2, 3 };
        System.out.println(lowerBound(arr1, 2));
        int arr2[] = { 3, 5, 8, 15, 19 };
        System.out.println(lowerBound(arr2, 9));
    }
}
