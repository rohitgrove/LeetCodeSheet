import java.util.HashSet;

public class LongestBalancedSubarray1 {
    public static int longestBalanced(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> odd = new HashSet<>();
            HashSet<Integer> even = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if ((nums[j] & 1) == 0) {
                    even.add(nums[j]);
                } else {
                    odd.add(nums[j]);
                }

                if (odd.size() == even.size()) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 5, 4, 3 };
        System.out.println(longestBalanced(nums1));
        int nums2[] = { 3, 2, 2, 5, 4 };
        System.out.println(longestBalanced(nums2));
        int nums3[] = { 1, 2, 3, 2 };
        System.out.println(longestBalanced(nums3));
    }
}
