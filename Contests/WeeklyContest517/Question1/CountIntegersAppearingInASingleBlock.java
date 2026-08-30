import java.util.HashMap;

public class CountIntegersAppearingInASingleBlock {
    public static int countSpecialIntegers1(int[] nums) {
        HashMap<Integer, Integer> blocks = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                blocks.put(nums[i], blocks.getOrDefault(nums[i], 0) + 1);
            }
        }

        int count = 0;

        for (int value : blocks.values()) {
            if (value == 1) {
                count++;
            }
        }

        return count;
    }

    public static int countSpecialIntegers2(int[] nums) {
        boolean[] seen = new boolean[101];
        boolean[] bad = new boolean[101];

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            if (seen[x] && (i == 0 || nums[i - 1] != x)) {
                bad[x] = true;
            }

            seen[x] = true;
        }

        int count = 0;

        for (int i = 1; i <= 100; i++) {
            if (seen[i] && !bad[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 };
        System.out.println(countSpecialIntegers1(nums1));
        System.out.println(countSpecialIntegers2(nums1));

        int[] nums2 = { 3, 3, 1, 2, 2, 1 };
        System.out.println(countSpecialIntegers1(nums2));
        System.out.println(countSpecialIntegers2(nums2));
    }
}
