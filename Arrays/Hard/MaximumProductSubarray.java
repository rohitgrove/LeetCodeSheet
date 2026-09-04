public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {
            // if any of the leftProduct or RightProduct becomes zero then take product as 1
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            // prefix product (means from left to right)
            leftProduct *= nums[i];
            // suffix product (means right to left)
            rightProduct *= nums[n - 1 - i];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 3, -2, 4 };
        System.out.println(maxProduct(nums1));
        int nums2[] = { -2, 0, -1 };
        System.out.println(maxProduct(nums2));
    }
}
