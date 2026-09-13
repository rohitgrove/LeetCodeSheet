import java.util.ArrayList;
import java.util.List;

public class CountShadowPairs1 {
    public static long shadowPairs(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        long ans = 0;
        for (int x : nums) {
            int left = 0;
            int right = stack.size();

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (stack.get(mid) < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            ans += left;

            while (!stack.isEmpty() && stack.get(stack.size() - 1) > x) {
                stack.remove(stack.size() - 1);
            }

            stack.add(x);
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 1, 4, 1, 5 };
        System.out.println(shadowPairs(nums1));
        int nums2[] = { 6, 7, 6, 6, 7 };
        System.out.println(shadowPairs(nums2));
        int nums3[] = { 1, 2, 3, 4 };
        System.out.println(shadowPairs(nums3));
    }
}
