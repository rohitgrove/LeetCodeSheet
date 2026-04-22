public class RecursiveBubbleSort {
    public static void bubbleSort(int[] arr, int n) {
        // Base case: array of size 1 is already sorted
        if (n == 1) {
            return;
        }

        // Push the largest element to the end
        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j + 1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        // Recurse for the remaining unsorted array
        bubbleSort(arr, n - 1);
    }

    public static void bubbleSortOpti(int[] arr, int n) {
        // Base case
        if (n == 1) {
            return;
        }

        boolean didSwap = false; // Track if any swap occurred

        // Perform one pass of bubble sort
        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j + 1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                didSwap = true;
            }
        }

        // If no swaps were made, the array is already sorted
        if (!didSwap) {
            return;
        }

        // Recur for remaining elements
        bubbleSortOpti(arr, n - 1);
    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 13, 46, 24, 52, 20, 9 };
        int n = arr.length;

        System.out.println("Before Using Bubble Sort:");
        printArr(arr);

        bubbleSort(arr, n);

        System.out.println("After Using Bubble Sort:");
        printArr(arr);
    }
}