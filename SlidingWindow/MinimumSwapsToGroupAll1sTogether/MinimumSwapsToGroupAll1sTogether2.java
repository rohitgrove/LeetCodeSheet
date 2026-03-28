public class MinimumSwapsToGroupAll1sTogether2 {
    public static int bruteForce(int[] nums) {
        int n = nums.length;

        // Count total 1s
        int k = 0;
        for (int x : nums) {
            if (x == 1) {
                k++;
            }
        }

        if (k == 0) {
            return 0;
        }

        int maxOnes = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < k; j++) {
                if (nums[(i + j) % n] == 1) {
                    count++;
                }
            }

            maxOnes = Math.max(maxOnes, count);
        }

        return k - maxOnes;
    }

    public static int optimizedApproach(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;

        for (int num : nums) {
            totalOnes += num;
        }

        if (totalOnes == 0 || totalOnes == n) {
            return 0;
        }
        int currentOnes = 0;

        for (int i = 0; i < totalOnes; i++) {
            currentOnes += nums[i];
        }

        int maxOnes = currentOnes;

        for (int i = 0; i < n; i++) {
            currentOnes -= nums[i];
            currentOnes += nums[(i + totalOnes) % n];
            maxOnes = Math.max(maxOnes, currentOnes);
        }

        return totalOnes - maxOnes;
    }

    public static int minSwaps(int[] nums) {
        return optimizedApproach(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 0, 1, 0, 1 };
        System.out.println(minSwaps(nums1));
        int nums2[] = { 0, 1, 0, 1, 1, 0, 0 };
        System.out.println(minSwaps(nums2));
        int nums3[] = { 0, 1, 1, 1, 0, 0, 1, 1, 0 };
        System.out.println(minSwaps(nums3));
        int nums4[] = { 1, 1, 0, 0, 1 };
        System.out.println(minSwaps(nums4));
    }
}
