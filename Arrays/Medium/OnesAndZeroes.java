public class OnesAndZeroes {
    public static void sort0And1(int arr[]) {
        int zero = 0;
        int ones = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zero++;
            }
            if (arr[i] == 1) {
                ones++;
            }
        }

        int idx = 0;
        while (zero > 0) {
            arr[idx] = 0;
            zero--;
            idx++;
        }

        while (ones > 0) {
            arr[idx] = 1;
            ones--;
            idx++;
        }
    }

    public static void sort0And1OtherApproach(int arr[]) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] == 0) {
                left++;
            } else if (arr[right] == 1) {
                right--;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void printArr(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
        printArr(arr);
        sort0And1OtherApproach(arr);
        printArr(arr);
    }
}
