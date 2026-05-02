import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                ans.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        ans.add(new int[] { start, end });

        return ans.toArray(new int[0][]);
    }

    public static void printArr(int intervals[][]) {
        for (int[] row : intervals) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int intervals[][] = { { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 18 } };
        printArr(merge(intervals));
    }
}
