import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length; i++) {
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
            // if the current interval lies in the last interval:
            else {
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), intervals[i][1]));
                // we have to take the end value which is max from both the arrays-comparision
            }
        }

        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }

        return result;
    }

    public static void printArr(int[][] intervals) {
        for (int[] interval : intervals) {
            for (int j = 0; j < interval.length; j++) {
                System.out.print(interval[j] + " ");
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
