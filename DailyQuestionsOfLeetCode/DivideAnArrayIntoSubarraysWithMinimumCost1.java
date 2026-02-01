public class DivideAnArrayIntoSubarraysWithMinimumCost1 {
    public static int minimumCost(int[] nums) {
        int a = 51, b = 51;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < a) {
                b = a;
                a = nums[i];
            } else if (nums[i] < b)
                b = nums[i];
        }

        return nums[0] + a + b;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 12 };
        System.out.println(minimumCost(nums1));
        int nums2[] = { 5, 4, 3 };
        System.out.println(minimumCost(nums2));
        int nums3[] = { 10, 3, 1, 1 };
        System.out.println(minimumCost(nums3));
    }
}
