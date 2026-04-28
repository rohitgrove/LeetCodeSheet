public class NextPermutation {
    public static void nextPermutation(int arr[]) {
        int n = arr.length;

        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            reverse(arr, 0, n - 1);
            return;
        }

        int j = n - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        swap(arr, i, j);

        reverse(arr, i + 1, n - 1);
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int arr[], int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3 };
        nextPermutation(nums1);
        printArr(nums1);
        int nums2[] = { 3, 2, 1 };
        nextPermutation(nums2);
        printArr(nums2);
        int nums3[] = { 1, 1, 5 };
        nextPermutation(nums3);
        printArr(nums3);
    }
}
