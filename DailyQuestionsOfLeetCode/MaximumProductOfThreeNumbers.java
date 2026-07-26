public class MaximumProductOfThreeNumbers {
    public static int bruteForce(int nums[]) {
        int maxProd = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {

                    int prod = nums[i] * nums[j] * nums[k];
                    maxProd = Math.max(maxProd, prod);
                }
            }
        }

        return maxProd;
    }

    public static int optimizeApproach(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            // Update three largest numbers
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }

            // Update two smallest numbers
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    public static int maximumProduct(int[] nums) {
        return optimizeApproach(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3 };
        System.out.println(maximumProduct(nums1));
        int nums2[] = { 1, 2, 3, 4 };
        System.out.println(maximumProduct(nums2));
        int nums3[] = { -1, -2, -3 };
        System.out.println(maximumProduct(nums3));
        int nums4[] = { -100, -98, -1, 2, 3, 4 };
        System.out.println(maximumProduct(nums4));
    }
}
