public class MaximumProductSubArray {
    public static int maxProduct(int[] nums) {
        int rightProd = 1;
        int leftProd = 1;
        int result = Integer.MIN_VALUE;

        int i = 0;
        while (i < nums.length) {
            rightProd *= nums[i];
            leftProd *= nums[nums.length - 1 - i];

            result = Math.max(result, Math.max(rightProd, leftProd));

            if (rightProd == 0) {
                rightProd = 1;
            }
            if (leftProd == 0) {
                leftProd = 1;
            }

            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 3, -2, 4 };
        System.out.println(maxProduct(nums1));
        int nums2[] = { -2, 0, -1 };
        System.out.println(maxProduct(nums2));
    }
}
