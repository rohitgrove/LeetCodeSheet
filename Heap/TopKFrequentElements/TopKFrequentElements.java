import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count.putIfAbsent(nums[i], 0);
            count.put(nums[i], count.get(nums[i]) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Compare());

        for (int src : count.keySet()) {
            pq.offer(new Pair(src, count.get(src)));
        }

        int ans[] = new int[k];

        int idx = 0;

        while (k > 0) {
            Pair front = pq.poll();
            ans[idx++] = front.element;
            k--;
        }

        return ans;
    }

    public static void printArr(int nums[]) {
        for (int ele : nums) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 1, 2, 2, 3 }, k1 = 2;
        printArr(topKFrequent(nums1, k1));
        int nums2[] = { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 }, k2 = 2;
        printArr(topKFrequent(nums2, k2));
    }
}
