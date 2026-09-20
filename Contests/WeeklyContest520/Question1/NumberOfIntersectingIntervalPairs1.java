public class NumberOfIntersectingIntervalPairs1 {
    public static int countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.max(intervals[i][0], intervals[j][0]) <= Math.min(intervals[i][1], intervals[j][1])) {
                    count++;
                }
            }
        }

        return count;
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

        System.out.println(countIntersectingIntervals(intervals1));
        System.out.println(countIntersectingIntervals(intervals2));
        System.out.println(countIntersectingIntervals(intervals3));
    }
}