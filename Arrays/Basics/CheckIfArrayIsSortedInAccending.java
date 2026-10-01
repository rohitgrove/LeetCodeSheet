public class CheckIfArrayIsSortedInAccending {
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int arr1[] = { 10, 20, 30, 40, 50 };
        System.out.println(isSorted(arr1));
        int arr2[] = { 90, 80, 100, 70, 40, 30 };
        System.out.println(isSorted(arr2));
    }
}
