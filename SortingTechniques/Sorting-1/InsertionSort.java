public class InsertionSort {
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void printArr(int arr[]) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 5, 4, 3, 2, 1 };
        insertionSort(arr1);
        printArr(arr1);
        int arr2[] = { 13, 46, 24, 52, 20, 9 };
        insertionSort(arr2);
        printArr(arr2);
        int arr3[] = { 5, 4, 3, 1, 2 };
        insertionSort(arr3);
        printArr(arr3);
    }
}
