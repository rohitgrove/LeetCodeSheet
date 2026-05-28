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
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        System.out.println("Before Reverse: ");
        printArr(arr);
        System.out.println("After Reverse: ");
        reverse(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
