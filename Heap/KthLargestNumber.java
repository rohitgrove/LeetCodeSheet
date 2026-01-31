import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestNumber {
    public static int firstApproach(int nums[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }

        System.out.println(pq);

        while (k-- > 1) {
            pq.poll();
        }
        return pq.peek();
    }

    public static int secondApproach(int nums[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }

    public static int findKthLargest(int[] nums, int k) {
        return secondApproach(nums, k);
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 2, 1, 5, 6, 4 };
        System.out.println(findKthLargest(nums1, 2));
        int nums2[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        System.out.println(findKthLargest(nums2, 4));
    }
}
