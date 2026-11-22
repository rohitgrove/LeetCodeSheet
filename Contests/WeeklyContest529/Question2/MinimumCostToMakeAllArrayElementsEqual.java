public class MinimumCostToMakeAllArrayElementsEqual {
    public static long minCost(int[] nums) {
        int n = nums.length;
        long ans = Long.MAX_VALUE;

        int i = 0;

        while (i < n) {
            int j = i;

            while (j + 1 < n && nums[j] == nums[j + 1]) {
                j++;
            }

            int left = Math.max(i, 1);
            int right = Math.min(j, n - 2);

            if (left <= right) {
                long cost = 0;

                if (i > 0) {
                    cost += (long) left * nums[i];
                }

                if (j < n - 1) {
                    cost += (long) (n - right - 1) * nums[i];
                }

                ans = Math.min(ans, cost);
            }
            i = j + 1;
        }

        if (ans == Long.MAX_VALUE) {
            return 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3 };
        System.out.println(minCost(nums1));
        int[] nums2 = { 3, 3, 3, 6, 3, 3 };
        System.out.println(minCost(nums2));
        int[] nums3 = { 3, 4, 4, 5, 4, 4, 3 };
        System.out.println(minCost(nums3));
        int[] nums4 = { 3, 4, 4, 5, 4, 4, 3 };
        System.out.println(minCost(nums4));
    }
}
