public class FindSecondSmallestAndSecondLargestElement {
    public static void getElements(int[] arr, int n) {
        int smallest = Integer.MAX_VALUE;
        int greatest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            smallest = Math.min(arr[i], smallest);
            greatest = Math.max(arr[i], greatest);
        }

        int secondSmallest = Integer.MAX_VALUE;
        int secondGreatest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondSmallest && arr[i] != smallest) {
                smallest = arr[i];
            }
    
            if (arr[i] > secondGreatest && arr[i] != greatest) {
                secondGreatest = arr[i];
            }
        }

        System.out.println("Second smallest is " + secondSmallest);
        System.out.println("Second largest is " + secondGreatest);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 6, 7, 5 };
        int n = arr.length;

        getElements(arr, n);
    }
}
