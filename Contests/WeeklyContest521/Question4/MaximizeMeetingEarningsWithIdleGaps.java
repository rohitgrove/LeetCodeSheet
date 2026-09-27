import java.util.Arrays;

public class MaximizeMeetingEarningsWithIdleGaps {
    public static long maxEarnings(int[][] meetings) {
        int n = meetings.length;

        Arrays.sort(meetings, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            ends[i] = meetings[i][1];
        }

        Arrays.sort(ends);

        int m = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 || ends[i] != ends[i - 1]) {
                ends[m++] = ends[i];
            }
        }

        Fenwick bit = new Fenwick(m);

        long answer = 0;

        for (int i = 0; i < n; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            int revenue = meetings[i][2];

            int pos = upperBound(ends, m, start);

            long best = bit.query(pos);

            long current = revenue;

            if (best > Long.MIN_VALUE / 8) {
                current = Math.max(current, revenue + start + best);
            }

            int updatePos = lowerBound(ends, m, end) + 1;

            bit.update(updatePos, current - end);

            answer = Math.max(answer, current);
        }

        return answer;
    }

    public static int lowerBound(int[] arr, int n, int target) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int upperBound(int[] arr, int n, int target) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[][] meetings1 = {
                { 2, 5, 4 },
                { 6, 8, 3 }
        };
        System.out.println(maxEarnings(meetings1));

        int[][] meetings2 = {
                { 4, 7, 8 },
                { 8, 10, 3 }
        };
        System.out.println(maxEarnings(meetings2));

        int[][] meetings3 = {
                { 1, 2, 2 },
                { 4, 5, 2 },
                { 7, 9, 3 }
        };
        System.out.println(maxEarnings(meetings3));
    }
}