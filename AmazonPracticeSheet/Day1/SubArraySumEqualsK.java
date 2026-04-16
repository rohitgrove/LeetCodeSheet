// https://leetcode.com/problems/subarray-sum-equals-k/description/

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static int bruteForce(int nums[], int k) {
        int totalSubSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    totalSubSum += 1;
                }
            }
        }
        return totalSubSum;
    }

    public static int optimizedApproach(int nums[], int k) {
        int sum = 0;
        int totalSubSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                totalSubSum++;
            }

            if (map.containsKey(sum - k)) {
                totalSubSum += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return totalSubSum;
    }

    public static int subarraySum(int[] nums, int k) {
        return optimizedApproach(nums, k);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 1 }, k1 = 2;
        System.out.println(subarraySum(nums1, k1));
        int nums2[] = { 1, 2, 3 }, k2 = 3;
        System.out.println(subarraySum(nums2, k2));
    }
}
