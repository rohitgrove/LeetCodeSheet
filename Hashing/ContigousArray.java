import java.util.HashMap;

public class ContigousArray {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<>();

        h.put(0, -1);
        int sum = 0, ans = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1) ? 1 : -1;
            if (h.containsKey(sum)) {
                ans = Math.max(ans, i - h.get(sum));
            } else {
                h.put(sum, i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 0, 1 };
        System.out.println(findMaxLength(nums1));
        int nums2[] = { 0, 1, 0 };
        System.out.println(findMaxLength(nums2));
        int nums3[] = { 0, 1, 1, 1, 1, 1, 0, 0, 0 };
        System.out.println(findMaxLength(nums3));
    }
}
