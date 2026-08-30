public class RemovingMinimumAndMaximumFromArray {
    public static int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0, maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIndex])
                minIndex = i;
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // Remove both from the front
        int front = right + 1;

        // Remove both from the back
        int back = n - left;

        // Remove one from each side
        int frontBack = (left + 1) + (n - right);

        return Math.min(front, Math.min(back, frontBack));
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 10, 7, 5, 4, 1, 8, 6 };
        System.out.println(minimumDeletions(nums1));
        int nums2[] = { 0, -4, 19, 1, 8, -2, -3, 5 };
        System.out.println(minimumDeletions(nums2));
        int nums3[] = { 101 };
        System.out.println(minimumDeletions(nums3));
    }
}
