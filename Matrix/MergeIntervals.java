import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[] { start, end });
        return list.toArray(new int[0][]);
    }


    public static void printArr(int matrix[][]) {
        for (int[] row : matrix) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int intervals1[][] = { { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 18 } };
        printArr(merge(intervals1));
        int intervals2[][] = { { 1, 4 },
                { 4, 5 } };
        printArr(merge(intervals2));
        int intervals3[][] = { { 4, 7 },
                { 1, 4 } };
        printArr(merge(intervals3));
    }
}
