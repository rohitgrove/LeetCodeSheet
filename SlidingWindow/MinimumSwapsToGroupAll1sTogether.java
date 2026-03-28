public class MinimumSwapsToGroupAll1sTogether {
    public static int bruteForce(int nums[]) {
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                k++;
            }
        }

        if (k == 0) {
            return -1;
        }

        int maxOnes = 0;

        for (int i = 0; i <= n - k; i++) {
            int ones = 0;

            for (int j = i; j < i + k; j++) {
                if (nums[j] == 1) {
                    ones++;
                }
            }

            maxOnes = Math.max(maxOnes, ones);
        }

        return k - maxOnes;
    }

    public static int optimizedApproach(int[] arr) {
        int ones = 0;

        for (int x : arr) {
            if (x == 1)
                ones++;
        }

        if (ones == 0)
            return -1;

        int windowOnes = 0;

        for (int i = 0; i < ones; i++) {
            if (arr[i] == 1)
                windowOnes++;
        }

        int maxOnes = windowOnes;

        for (int i = ones; i < arr.length; i++) {
            if (arr[i] == 1) {

                windowOnes++;
            }
            if (arr[i - ones] == 1) {
                windowOnes--;
            }

            maxOnes = Math.max(maxOnes, windowOnes);
        }

        return ones - maxOnes;
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
