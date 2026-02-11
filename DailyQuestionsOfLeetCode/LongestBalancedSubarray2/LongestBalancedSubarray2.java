import java.util.HashMap;

public class LongestBalancedSubarray2 {
    public static int longestBalanced(int[] nums) {
        int n = nums.length;

        SegmentTree st = new SegmentTree(n);

        int ans = 0;

        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int par = nums[i] & 1;
            if (par == 0) par--;

            int low = 0;
            if (mpp.containsKey(nums[i])) {
                low = mpp.get(nums[i]) + 1;
            }

            mpp.put(nums[i], i);

            st.updateRange(0, 0, n - 1, low, i, par);

            int ind = st.get(0, 0, n - 1);
            if (ind != -1 && ind <= i) {
                ans = Math.max(ans, i - ind + 1);
            }
        }

        return ans;
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