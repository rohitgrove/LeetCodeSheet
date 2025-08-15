import java.util.HashMap;

public class SubarraysDivByK {
    public static int bruteForce(int nums[], int k) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static int optimizedApproach(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> prefixMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int mod = sum % k;
            if (mod == 0) {
                count++;
            }

            if (mod < 0) {
                mod += k;
            }

            if (prefixMap.containsKey(mod)) {
                count += prefixMap.get(mod);
            }

            prefixMap.put(mod, prefixMap.getOrDefault(mod, 0) + 1);
        }

        return count;
    }

    public static int subarraysDivByK(int[] nums, int k) {
        return optimizedApproach(nums, k);
    }

    public static void main(String[] args) {
        int nums1[] = { 4, 5, 0, -2, -3, 1 }, k1 = 5;
        System.out.println(subarraysDivByK(nums1, k1));
        int nums2[] = { -1, 2, 9 }, k2 = 2;
        System.out.println(subarraysDivByK(nums2, k2));
    }
}
