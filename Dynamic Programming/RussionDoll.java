import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Compare implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
            return o2[1] - o1[1];
        }
        return o1[0] - o2[0];
    }
}

public class RussionDoll {
    public static int solveUsingBS(int env[][]) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(env[0][1]);
        for (int i = 1; i < env.length; i++) {
            if (env[i][1] > ans.getLast()) {
                ans.add(env[i][1]);
            } else {
                int index = Collections.binarySearch(ans, env[i][1]);
                if (index < 0) {
                    index = Math.abs(index) - 1;
                }

                ans.set(index, env[i][1]);
            }
        }

        return ans.size();
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Compare());
        return solveUsingBS(envelopes);
    }

    public static void main(String[] args) {
        int envelopes1[][] = { { 5, 4 },
                { 6, 4 },
                { 6, 7 },
                { 2, 3 } };
        System.out.println(maxEnvelopes(envelopes1));
        int envelopes2[][] = { { 1, 1 },
                { 1, 1 },
                { 1, 1 } };
        System.out.println(maxEnvelopes(envelopes2));
    }
}
