public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
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
        selectionSort(arr1);
        printArr(arr1);
        int arr2[] = { 13, 46, 24, 52, 20, 9 };
        selectionSort(arr2);
        printArr(arr2);
        int arr3[] = { 5, 4, 3, 1, 2 };
        selectionSort(arr3);
        printArr(arr3);
    }
}
