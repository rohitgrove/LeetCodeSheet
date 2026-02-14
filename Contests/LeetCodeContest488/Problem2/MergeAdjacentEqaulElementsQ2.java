import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MergeAdjacentEqaulElementsQ2 {
    public static List<Long> mergeAdjacentEqualElements(int[] nums) {
        Deque<Long> stack = new ArrayDeque<>();

        for (int x : nums) {
            long curr = x;
            while (!stack.isEmpty() && stack.peekLast() == curr) {
                stack.pollLast();
                curr *= 2;
            }

            stack.addLast(curr);
        }

        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 1, 1, 2 };
        System.out.println(mergeAdjacentEqualElements(nums1));
        int nums2[] = { 2, 2, 4 };
        System.out.println(mergeAdjacentEqualElements(nums2));
        int nums3[] = { 3, 7, 5 };
        System.out.println(mergeAdjacentEqualElements(nums3));
    }
}
