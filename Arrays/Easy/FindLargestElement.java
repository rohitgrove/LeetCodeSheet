import java.util.Arrays;

public class FindLargestElement {
    public static int sortArr(int[] arr) {
        Arrays.sort(arr);

        return arr[arr.length - 1];
    }

    public static int findLargestElement(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 5, 1, 3, 0 };
        int[] arr2 = { 8, 10, 5, 7, 9 };

        // Find and output the largest element in both arrays
        System.out.println("The Largest element in the array is: " + sortArr(arr1));
        System.out.println("The Largest element in the array is: " + sortArr(arr2));
        // Find and output the largest element in both arrays
        System.out.println("The Largest element in the array is: " + findLargestElement(arr1));
        System.out.println("The Largest element in the array is: " + findLargestElement(arr2));
    }
}
