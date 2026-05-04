public class UpperBound {
    public static int upperBound(int[] arr, int target) {
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

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 2, 3 };
        System.out.println(upperBound(arr1, 2));
        int arr2[] = { 3, 5, 8, 15, 19 };
        System.out.println(upperBound(arr2, 9));
        int arr3[] = { 10, 20, 30, 30, 30, 30, 40, 50 };
        System.out.println(upperBound(arr3, 30));
    }
}
