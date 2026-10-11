public class MaximumProductPairWithTargetSum {
    public static int[] maxProductPair(int[] nums, int target) {
        int maxProduct = Integer.MIN_VALUE;
        int[] ans = { -1, -1 };

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target && nums[i] > nums[j]) {
                    int product = nums[i] * nums[j];

                    if (product > maxProduct) {
                        maxProduct = product;
                        ans[0] = i;
                        ans[1] = j;
                    }
                }
            }
        }

        return ans;
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 4 }, target1 = 5;
        printArr(maxProductPair(nums1, target1));
        int nums2[] = { -3, -1, 4, 2 }, target2 = 1;
        printArr(maxProductPair(nums2, target2));
        int nums3[] = { 3, 3, 5 }, target3 = 6;
        printArr(maxProductPair(nums3, target3));
    }
}
