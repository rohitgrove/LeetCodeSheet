import java.util.Arrays;

public class NumberOfIntersectingIntervalPairs2 {
    public static long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        long nonIntersecting = 0;
        int j = 0;

        for (int start : starts) {
            while (j < n && ends[j] < start) {
                j++;
            }
            nonIntersecting += j;
        }

        long totalPairs = (long) n * (n - 1) / 2;

        return totalPairs - nonIntersecting;
    }

    public static void main(String[] args) {
        int[][] intervals1 = { { 1, 2 },
                { 2, 3 },
                { 3, 4 } };
        int[][] intervals2 = { { 1, 5 },
                { 2, 4 },
                { 3, 6 } };
        int[][] intervals3 = { { 1, 2 },
                { 3, 4 },
                { 5, 6 } };
        int[][] intervals4 = { { 1, 1 },
                { 1, 1 },
                { 2, 2 } };
        int[][] intervals5 = { { 1, 10 },
                { 2, 3 },
                { 4, 5 },
                { 6, 7 },
                { 8, 9 } };

        System.out.println(countIntersectingIntervals(intervals1));
        System.out.println(countIntersectingIntervals(intervals2));
        System.out.println(countIntersectingIntervals(intervals3));
        System.out.println(countIntersectingIntervals(intervals4));
        System.out.println(countIntersectingIntervals(intervals5));
    }
}