import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class MaximumScoreOfNonOverlappingIntervalsMemoization {
    static int n;
    static int[][] intervals; // sorted, duplicate-free {left, right, weight}
    static int[] origIdx; // origIdx[i] = original index of intervals[i]
    static int[] nextIndex;
    static State[][] dp;

    public static int[] maximumWeight(List<List<Integer>> a) {
        // Remove duplicates, keeping the smallest original index
        LinkedHashMap<String, Integer> originalIndex = new LinkedHashMap<>();
        for (int i = 0; i < a.size(); i++) {
            List<Integer> iv = a.get(i);
            String key = iv.get(0) + "," + iv.get(1) + "," + iv.get(2);
            if (!originalIndex.containsKey(key)) {
                originalIndex.put(key, i);
            }
        }

        List<int[]> withIndex = new ArrayList<>();
        for (String key : originalIndex.keySet()) {
            String[] parts = key.split(",");
            withIndex.add(new int[] {
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1]),
                    Integer.parseInt(parts[2]),
                    originalIndex.get(key)
            });
        }

        withIndex.sort((x, y) -> {
            if (x[0] != y[0]) {
                return Integer.compare(x[0], y[0]);
            }
            if (x[1] != y[1]) {
                return Integer.compare(x[1], y[1]);
            }
            return Integer.compare(x[2], y[2]);
        });

        n = withIndex.size();
        intervals = new int[n][3];
        origIdx = new int[n];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = withIndex.get(i)[0];
            intervals[i][1] = withIndex.get(i)[1];
            intervals[i][2] = withIndex.get(i)[2];
            origIdx[i] = withIndex.get(i)[3];
        }

        nextIndex = new int[n];
        for (int i = 0; i < n; i++) {
            int right = intervals[i][1];
            int lo = 0, hi = n;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (intervals[mid][0] > right)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            nextIndex[i] = lo;
        }

        dp = new State[n + 1][5];

        List<Integer> resultList = solve(0, 4).indices;
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static State solve(int i, int k) {
        if (i == n || k == 0) {
            return new State(0, new ArrayList<>());
        }
        if (dp[i][k] != null) {
            return dp[i][k];
        }

        State skip = solve(i + 1, k);

        int weight = intervals[i][2];
        State takeNext = solve(nextIndex[i], k - 1);

        long takeScore = takeNext.score - weight;
        List<Integer> takeIndices = new ArrayList<>(takeNext.indices);
        takeIndices.add(origIdx[i]);
        Collections.sort(takeIndices);
        State take = new State(takeScore, takeIndices);

        State best = (skip.compareTo(take) <= 0) ? skip : take;
        dp[i][k] = best;
        return best;
    }

    public static void printAns(int ans[]) {
        for (int ele : ans) {
            System.out.print(ele + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        List<List<Integer>> intervals1 = Arrays.asList(
                Arrays.asList(1, 3, 2),
                Arrays.asList(4, 5, 2),
                Arrays.asList(1, 5, 5),
                Arrays.asList(6, 9, 3),
                Arrays.asList(6, 7, 1),
                Arrays.asList(8, 9, 1));
        printAns(maximumWeight(intervals1));
        List<List<Integer>> intervals2 = Arrays.asList(
                Arrays.asList(5, 8, 1),
                Arrays.asList(6, 7, 7),
                Arrays.asList(4, 7, 3),
                Arrays.asList(9, 10, 6),
                Arrays.asList(7, 8, 2),
                Arrays.asList(11, 14, 3),
                Arrays.asList(3, 5, 5));
        printAns(maximumWeight(intervals2));
    }
}