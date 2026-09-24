public class KthMissingPositiveNumbers {
    public static int findKthPositive2(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;
    }

    public static int findKthPositive1(int[] arr, int k) {
        for (int i : arr) {
            if (i <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 3, 4, 7, 11 };
        System.out.println(findKthPositive1(arr1, 5));
        int arr2[] = { 1, 2, 3, 4 };
        System.out.println(findKthPositive1(arr2, 2));
    }
}
