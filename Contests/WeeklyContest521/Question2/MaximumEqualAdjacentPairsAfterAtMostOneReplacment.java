import java.util.HashMap;

public class MaximumEqualAdjacentPairsAfterAtMostOneReplacment {
    public static int maxEqualAdjacentPairs(int[] nums) {
        int base = 0;
        int maxGain = 0;

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];

            if (a == b) {
                base++;
            } else {
                int x = Math.min(a, b);
                int y = Math.max(a, b);

                long key = ((long) x << 32) | (y & 0xffffffffL);

                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);

                maxGain = Math.max(maxGain, count);
            }
        }

        return base + maxGain;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 2 };
        System.out.println(maxEqualAdjacentPairs(nums1));
        int[] nums2 = { 1, 2, 1, 2, 1 };
        System.out.println(maxEqualAdjacentPairs(nums2));
        int[] nums3 = { 1, 1, 1 };
        System.out.println(maxEqualAdjacentPairs(nums3));
    }
}