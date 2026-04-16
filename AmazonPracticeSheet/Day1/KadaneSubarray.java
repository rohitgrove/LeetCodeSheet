public class KadaneSubarray {
    public static int kadanes(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            currSum += numbers[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }

            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int numbers[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(kadanes(numbers));
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(kadanes(arr));
        int nums[] = { 5, 4, -1, 7, 8 };
        System.out.println(kadanes(nums));
    }
}
