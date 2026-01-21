import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElement {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int integer : arr) {
            if (k > 0) {
                minHeap.offer(integer);
                k--;
            } else if (Math.abs(minHeap.peek() - x) > Math.abs(integer - x)) {
                minHeap.poll();
                minHeap.offer(integer);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5 };
        System.out.println(findClosestElements(arr1, 4, 3));
        int arr2[] = { 1, 1, 2, 3, 4, 5 };
        System.out.println(findClosestElements(arr2, 4, -1));
    }
}
