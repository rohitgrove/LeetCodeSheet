import java.util.HashSet;

public class LongestSubaarayDivisibleByKWithAtMostOneNegation1 {
    public static int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        for (int l = 0; l < n; l++) {
            long sum = 0;
            HashSet<Integer> set = new HashSet<>();

            for (int r = l; r < n; r++) {
                sum += nums[r];

                int value = (int) (((2L * nums[r]) % k + k) % k);
                set.add(value);

                int rem = (int) ((sum % k + k) % k);

                if (rem == 0 || set.contains(rem)) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int k1 = 3;

        int[] nums2 = { 5, 3, 4 };
        int k2 = 7;

        int[] nums3 = { 2, 2, 5 };
        int k3 = 6;

        System.out.println(longestSubarray(nums1, k1));
        System.out.println(longestSubarray(nums2, k2));
        System.out.println(longestSubarray(nums3, k3));
    }
}
