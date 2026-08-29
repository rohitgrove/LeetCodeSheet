public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot >= 0) {
            for (int i = n - 1; i > 0; i--) {
                if (nums[pivot] < nums[i]) {
                    swap(nums, pivot, i);
                    break;
                }
            }
        }

        reverse(nums, pivot + 1, nums.length - 1);
    }

    public static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void reverse(int arr[], int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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
