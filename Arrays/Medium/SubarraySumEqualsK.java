
import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int bruteForce(int nums[], int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int betterApproach(int nums[], int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int optimizedApproach(int nums[], int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        prefixSumCount.put(0, 1);

        for (int start = 0; start < nums.length; start++) {
            prefixSum += nums[start];

            int remove = prefixSum - k;
            if (prefixSumCount.containsKey(remove)) {
                count += prefixSumCount.get(remove);
            }
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        return optimizedApproach(nums, k);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 1 };
        System.out.println(subarraySum(nums1, 2));
        int nums2[] = { 1, 2, 3 };
        System.out.println(subarraySum(nums2, 3));
    }
}
