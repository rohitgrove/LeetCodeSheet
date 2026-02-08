public class PartitionArrayIntoDisjointIntervals {
    public static int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int ans = 1; // assume the min. size of left part is 1
        int leftMaxSofar = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            if (nums[i] < leftMaxSofar) {
                ans = i + 1;
                leftMaxSofar = maxSoFar;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 5, 0, 3, 8, 6 };
        System.out.println(partitionDisjoint(nums1));
        int nums2[] = { 1, 1, 1, 0, 6, 12 };
        System.out.println(partitionDisjoint(nums2));
    }
}
