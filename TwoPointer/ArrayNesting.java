public class ArrayNesting {
    public static int arrayNesting(int[] nums) {
        int maxVal = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != maxVal) {
                int start = nums[i], count = 0;
                while (nums[start] != maxVal) {
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = maxVal;
                }
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 5, 4, 0, 3, 1, 6, 2 };
        System.out.println(arrayNesting(nums1));
        int nums2[] = { 0, 1, 2 };
        System.out.println(arrayNesting(nums2));
    }
}
