import java.util.PriorityQueue;

public class MaximumProductOfTwoElementsInAnArray {
    public static int approach1(int nums[]) {
        if (nums.length == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max2 = num;
            }
        }

        int prod = (max1 - 1) * (max2 - 1);

        return prod;
    }

    public static int approach2(int nums[]) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < 2; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = 2; i < nums.length; i++) {
            int ele = nums[i];
            if (ele > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(ele);
            }
        }

        int ele1 = minHeap.poll();
        int ele2 = minHeap.poll();

        int prod = (ele1 - 1) * (ele2 - 1);

        return prod;
    }

    public static int maxProduct(int[] nums) {
        return approach2(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 4, 5, 2 };
        System.out.println(maxProduct(nums1));
        int nums2[] = { 1, 5, 4, 5 };
        System.out.println(maxProduct(nums2));
        int nums3[] = { 3, 7 };
        System.out.println(maxProduct(nums3));
    }
}
