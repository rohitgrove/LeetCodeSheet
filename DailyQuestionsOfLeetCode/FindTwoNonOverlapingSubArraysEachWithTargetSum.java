import java.util.Arrays;

public class FindTwoNonOverlapingSubArraysEachWithTargetSum {
    public static int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] best = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int currentLength = right - left + 1;

                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    answer = Math.min(answer, currentLength + best[left - 1]);
                }

                best[right] = currentLength;
            }

            if (right > 0) {
                best[right] = Math.min(best[right], best[right - 1]);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        int arr1[] = { 3, 2, 2, 4, 3 };
        System.out.println(minSumOfLengths(arr1, 2));
        int arr2[] = { 7, 3, 4, 7 };
        System.out.println(minSumOfLengths(arr2, 7));
        int arr3[] = { 4, 3, 2, 6, 2, 3, 4 };
        System.out.println(minSumOfLengths(arr3, 6));
    }
}
