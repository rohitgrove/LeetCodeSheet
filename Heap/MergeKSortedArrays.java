import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeArrays(int[][] mat) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int row[] : mat) {
            for (int ele : row) {
                pq.offer(ele);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        return ans;
    }

    public static void main(String[] args) {
        int mat1[][] = { { 1, 3, 5, 7 },
                { 2, 4, 6, 8 },
                { 0, 9, 10, 11 } };
        System.out.println(mergeArrays(mat1));
        int mat2[][] = { { 1, 2, 3, 4 },
                { 2, 2, 3, 4 },
                { 5, 5, 6, 6 },
                { 7, 8, 9, 9 } };
        System.out.println(mergeArrays(mat2));
    }
}
