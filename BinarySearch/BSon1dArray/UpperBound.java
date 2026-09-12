public class UpperBound {
    public static int upperBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 3, 7, 10, 11, 11, 25 };
        System.out.println(upperBound(arr1, 9));
        System.out.println(upperBound(arr1, 11));
        System.out.println(upperBound(arr1, 100));
        int arr2[] = { 1, 2, 2, 3 };
        System.out.println(upperBound(arr2, 2));
        int arr3[] = { 3, 5, 8, 15, 19 };
        System.out.println(upperBound(arr3, 9));
    }
}
