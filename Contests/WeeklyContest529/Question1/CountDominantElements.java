public class CountDominantElements {
    public static int countDominantElements(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (n == 1) {
                count++;
            } else if (i == 0) {
                if (nums[i] >= nums[i + 1]) {
                    count++;
                }
            } else if (i == n - 1) {
                if (nums[i] >= nums[i - 1]) {
                    count++;
                }
            } else {
                if (2 * nums[i] >= nums[i - 1] + nums[i + 1]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 10, 2 };
        System.out.println(countDominantElements(nums1));
        int nums2[] = { 6, 4, 2 };
        System.out.println(countDominantElements(nums2));
    }
}
