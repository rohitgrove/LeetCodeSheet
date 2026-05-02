import java.util.HashMap;

public class CountTheNumberOfSubarraysWithGivenXorK {
    public static int countSubarraysXOR(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int xorVal = 0;
            for (int j = i; j < nums.length; j++) {
                xorVal ^= nums[j];
                if (xorVal == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int prefixXor = 0;
        int count = 0;

        for (int num : nums) {
            prefixXor ^= num;

            int target = prefixXor ^ k;

            if (freq.containsKey(target)) {
                count += freq.get(target);
            }

            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int nums1[] = { 4, 2, 2, 6, 4 }, k1 = 6;
        System.out.println(countSubarraysXOR(nums1, k1));
        int nums2[] = { 5, 6, 7, 8, 9 }, k2 = 5;
        System.out.println(countSubarraysXOR(nums2, k2));
    }
}
