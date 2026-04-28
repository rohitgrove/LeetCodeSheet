public class ReplaceElementsWithGreatesElementOnRightSide {
    public static int[] bruteForce(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
            }
            arr[i] = max == Integer.MIN_VALUE ? -1 : max;
        }

        return arr;
    }

    public static int[] optimizedApproach(int[] arr) {
        int largest = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i]; // save
            arr[i] = largest; // replace with largest
            largest = Math.max(largest, current); // find the largest
        }
        return arr;
    }

    public static int[] replaceElements(int[] arr) {
        return optimizedApproach(arr);
    }

    public static void printArr(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 17, 18, 5, 4, 6, 1 };
        printArr(replaceElements(arr));
    }
}