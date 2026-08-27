import java.util.HashMap;
public class LongestSubarrayWithGivenSum {
    public static int bruteForce(int arr[], int k) {
        int subMaxArraySize = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    int currLen = j - i + 1;
                    subMaxArraySize = Math.max(subMaxArraySize, currLen);
                }
            }
        }

        return subMaxArraySize;
    }

    public static int optimizeApproach(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // From index 0 to i
            if (sum == k) {
                maxLength = i + 1;
            }

            // Check if a previous prefix sum exists
            if (map.containsKey(sum - k)) {
                int length = i - map.get(sum - k);
                maxLength = Math.max(maxLength, length);
            }

            // Store only the first occurrence
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static int longestSubarray(int[] arr, int k) {
        return optimizeApproach(arr, k);
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 5, 2, 7, 1, 9 };
        System.out.println(longestSubarray(nums1, 15));
        int nums2[] = { -3, 2, 1 };
        System.out.println(longestSubarray(nums2, 6));
        int nums3[] = { 10, 5, 2, 7, 1, -10 };
        System.out.println(longestSubarray(nums3, 15));
        int nums4[] = { -5, 8, -14, 2, 4, 12 };
        System.out.println(longestSubarray(nums4, -5));
        int nums5[] = { 10, -10, 20, 30 };
        System.out.println(longestSubarray(nums5, 5));
    }
}
