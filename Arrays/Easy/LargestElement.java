public class LargestElement {
    public static int largestElment(int arr[]) {
        int largestElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (largestElement < arr[i]) {
                largestElement = arr[i];
            }
        }

        return largestElement;
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 5, 1, 3, 0 };
        System.out.println(largestElment(arr1));
        int arr2[] = { 8, 10, 5, 7, 9 };
        System.out.println(largestElment(arr2));
    }
}
