public class MinimumIncrementToMakeArrayUnique {
    public static int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int max_val = 0;
        int minIncrements = 0;

        for (int val : nums) {
            max_val = Math.max(max_val, val);
        }

        int[] frequencyCount = new int[n + max_val];

        for (int val : nums) {
            frequencyCount[val]++;
        }

        for (int i = 0; i < frequencyCount.length; i++) {
            if (frequencyCount[i] <= 1) {
                continue;
            }

            int duplicates = frequencyCount[i] - 1;
            frequencyCount[i + 1] += duplicates;
            frequencyCount[i] = 1;
            minIncrements += duplicates;
        }

        return minIncrements;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 2 };
        System.out.println(minIncrementForUnique(nums1));
        int nums2[] = { 3, 2, 1, 2, 1, 7 };
        System.out.println(minIncrementForUnique(nums2));
    }
}
