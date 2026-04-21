public class ReverseAnArray {
    public static void reverse(int arr[], int s, int e) {
        if (s > e) {
            return;
        }

        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;

        reverse(arr, s + 1, e - 1);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5 };
        System.out.print("Original Array: ");
        printArr(nums);
        reverse(nums, 0, nums.length - 1);
        System.out.print("After Reverse Array: ");
        printArr(nums);
    }
}
