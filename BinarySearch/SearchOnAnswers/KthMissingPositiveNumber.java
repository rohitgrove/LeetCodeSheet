public class KthMissingPositiveNumber {
    public static int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        // Binary Search to find the position where the missing count crosses k
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Calculate how many numbers are missing before the index 'mid'
            // Expected value at index mid is (mid + 1)
            int missingNumbersTillNow = arr[mid] - (mid + 1);

            if (missingNumbersTillNow < k) {
                // Not enough missing numbers yet, look to the Right
                start = mid + 1;
            } else {
                // Too many (or exactly k) missing numbers, look to the Left
                end = mid - 1;
            }
        }

        // Derivation:
        // The answer is 'k' more than the number of non-missing elements found so far.
        // At the end of the loop, 'start' is the number of elements in the array
        // smaller than the kth missing number.
        // Formula: Result = k + start
        return k + start;
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 3, 4, 7, 11 };
        System.out.println(findKthPositive(arr1, 5));
        int arr2[] = { 1, 2, 3, 4 };
        System.out.println(findKthPositive(arr2, 2));
    }
}
