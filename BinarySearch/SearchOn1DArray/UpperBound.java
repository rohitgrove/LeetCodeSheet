public class UpperBound {
    public static int upperBound(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = arr.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                ans = mid;
                end = mid - 1; // left search
            } else {
                start = mid + 1; // right search
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 2, 3 };
        System.out.println(upperBound(arr1, 2));
        int arr2[] = { 3, 5, 8, 15, 19 };
        System.out.println(upperBound(arr2, 9));
    }
}
