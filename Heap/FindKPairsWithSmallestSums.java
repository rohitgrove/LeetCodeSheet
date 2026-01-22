import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return pairs;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((arr1, arr2) -> arr1[0] + arr1[1] - arr2[0] - arr2[1]);

        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[] { nums1[i], nums2[0], 0 });
        }

        while (k-- != 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            pairs.add(List.of(curr[0], curr[1]));
            if (curr[2] + 1 < nums2.length) {
                minHeap.offer(new int[] { curr[0], nums2[curr[2] + 1], curr[2] + 1 });
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 7, 11 }, nums2[] = { 2, 4, 6 }, k1 = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k1));
        int nums3[] = { 1, 1, 2 }, nums4[] = { 1, 2, 3 }, k2 = 2;
        System.out.println(kSmallestPairs(nums3, nums4, k2));
    }
}
