import java.util.HashMap;

public class SubArraySumEqualsByK {
    public static int bruteForce(int nums[], int k) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static int optimizedApproach(int nums[], int k) {
        int ans = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                ans++;
            }

            if (mp.containsKey(sum - k)) {
                ans += mp.get(sum - k);
            }

            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return ans;
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
