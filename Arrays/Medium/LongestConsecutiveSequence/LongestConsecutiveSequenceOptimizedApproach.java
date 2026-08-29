import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceOptimizedApproach {
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int longest = 1;
        Set<Integer> st = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            st.add(nums[i]);
        }

        for (int it : st) {
            if (!st.contains(it - 1)) {
                int cnt = 1;
                int target = it;
                while (st.contains(target + 1)) {
                    target = target + 1;
                    cnt = cnt+ 1;
                }

                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int nums1[] = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums1));
        int nums2[] = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutive(nums2));
        int nums3[] = { 1, 0, 1, 2 };
        System.out.println(longestConsecutive(nums3));
    }
}
