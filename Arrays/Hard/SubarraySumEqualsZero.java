import java.util.HashMap;

public class SubarraySumEqualsZero {
    public static int bruteForce(int[] nums) {
        int maxLen = 0;
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            // update running sum
            sum += nums[i];

            if (sum == 0) {
                maxLen = i + 1;
            } else if (sumIndexMap.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumIndexMap.get(sum));
            } else {
                sumIndexMap.put(sum, i);
            }
        }

        return maxLen;
    }

    public static int optimizedApproach(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (mpp.containsKey(sum)) {
                    maxi = Math.max(maxi, i - mpp.get(sum));
                } else {
                    mpp.put(sum, i);
                }
            }
        }

        return maxi;
    }

    public static int subarraySum(int[] nums) {
        return optimizedApproach(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 9, -3, 3, -1, 6, -5 };
        System.out.println(subarraySum(nums1));
        int nums2[] = { 6, -2, 2, -8, 1, 7, 4, -10 };
        System.out.println(subarraySum(nums2));
    }
}
