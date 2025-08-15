public class CountInversion {
    public static int mergeSort(int arr[], int temp[], int start, int end) {
        if (start >= end) {
            return 0;
        }

        int count = 0;
        int mid = start + (end - start) / 2;
        count += mergeSort(arr, temp, start, mid);
        count += mergeSort(arr, temp, mid + 1, end);

        count += sort(arr, temp, start, mid, end);
        return count;
    }

    public static int sort(int[] arr, int[] temp, int start, int mid, int end) {
        int i = start, j = mid + 1, k = start;
        int count = 0;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        while (start <= end) {
            arr[start] = temp[start];
            start++;
        }

        return count;
    }

    public static int countInversions(int arr[]) {
        int temp[] = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 4, 1, 3, 5 };
        System.out.println(countInversions(arr1));
        int arr2[] = { 2, 3, 4, 5, 6 };
        System.out.println(countInversions(arr2));
    }
}
