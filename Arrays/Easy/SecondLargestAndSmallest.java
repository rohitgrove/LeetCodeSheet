public class SecondLargestAndSmallest {
    public static int secondLargestElement(int arr[]) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    public static int secondSmallestElement(int arr[]) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (smallest > arr[i]) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < secondSmallest && arr[i] != smallest) {
                secondSmallest = arr[i];
            }
        }

        return secondSmallest;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 7, 7, 5 };
        System.out.println("Second smallest is " + secondSmallestElement(arr));
        System.out.println("Second largest is " + secondLargestElement(arr));
    }
}
