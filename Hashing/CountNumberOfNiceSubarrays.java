import java.util.HashMap;

public class CountNumberOfNiceSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1); // Base case

        int oddCount = 0, result = 0;

        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }

            // If (oddCount - k) has occurred before, add its count to result
            result += countMap.getOrDefault(oddCount - k, 0);

            // Record current oddCount
            countMap.put(oddCount, countMap.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 2, 1, 1 }, k1 = 3;
        System.out.println(numberOfSubarrays(nums1, k1));
        int nums2[] = { 2, 4, 6 }, k2 = 1;
        System.out.println(numberOfSubarrays(nums2, k2));
        int nums3[] = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 }, k3 = 2;
        System.out.println(numberOfSubarrays(nums3, k3));
    }
}
