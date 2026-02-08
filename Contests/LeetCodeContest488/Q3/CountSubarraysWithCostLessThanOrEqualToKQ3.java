import java.util.ArrayDeque;
import java.util.Deque;

public class CountSubarraysWithCostLessThanOrEqualToKQ3 {
    public static long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        long ans = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[r]) {
                maxD.pollLast();
            }
            maxD.addLast(r);

            while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[r]) {
                minD.pollLast();
            }
            minD.addLast(r);

            while (l <= r) {
                long maxVal = nums[maxD.peekFirst()];
                long minVal = nums[minD.peekFirst()];
                long len = r - l + 1;

                if ((maxVal - minVal) * len <= k) {
                    break;
                }

                if (maxD.peekFirst() == l) {
                    maxD.pollFirst();
                }
                if (minD.peekFirst() == l) {
                    minD.pollFirst();
                }
                l++;
            }

            ans += (r - l + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, 2 };
        System.out.println(countSubarrays(nums1, 4));
        int nums2[] = { 5, 5, 5, 5 };
        System.out.println(countSubarrays(nums2, 0));
        int nums3[] = { 1, 2, 3 };
        System.out.println(countSubarrays(nums3, 0));
    }
}
