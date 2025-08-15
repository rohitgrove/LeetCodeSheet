public class InPlaceMergeSort {
    public static void mergeSort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid + 1, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int total_len = end - start + 1;
        int gap = (total_len / 2) + (total_len % 2);

        while (gap > 0) {
            int i = start, j = start + gap;
            while (j <= end) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                ++i;
                ++j;
            }
            gap = gap <= 1 ? 0 : (gap / 2) + (gap % 2);
        }
    }

    public static void sortArray(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 3, 5, 1, 8, 2, 4 };
        sortArray(arr1);
        printArr(arr1);
        int arr2[] = { 3, 1, 4, 5, 2 };
        sortArray(arr2);
        printArr(arr2);
        int arr3[] = { 2, 4, 1, 6, 9 };
        sortArray(arr3);
        printArr(arr3);
        int arr4[] = { 4, 2, 5, 1, 3 };
        sortArray(arr4);
        printArr(arr4);
        int arr5[] = { 6, 2, 4, 1 };
        sortArray(arr5);
        printArr(arr5);
        int arr6[] = { 5, 3, 2, 6, 4 };
        sortArray(arr6);
        printArr(arr6);
        int arr7[] = { 7, 2, 1, 8, 6, 3, 5, 4 };
        sortArray(arr7);
        printArr(arr7);
        int[] arr8 = { 50, 40, 80, 90, 70, 10, 30, 60, 120 };
        sortArray(arr8);
        printArr(arr8);
        int arr9[] = { 2, 1, 6, 9, 4, 5 };
        sortArray(arr9);
        printArr(arr9);
    }
}
