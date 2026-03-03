import java.util.Arrays;

public class MaximumHeightbyStackingCuboids {
    public static boolean check(int[] curr, int[] prev) {
        return prev[0] <= curr[0] && prev[1] <= curr[1] && prev[2] <= curr[2];
    }

    public static int solveUsingTabulationSO(int[][] cuboids) {
        int n = cuboids.length;
        int nextRow[] = new int[n + 1];
        int currRow[] = new int[n + 1];

        for (int curr_index = n - 1; curr_index >= 0; curr_index--) {
            for (int prev_index = curr_index - 1; prev_index >= -1; prev_index--) {
                int include = 0;
                if (prev_index == -1 || check(cuboids[curr_index], cuboids[prev_index])) {
                    int heightToAdd = cuboids[curr_index][2];
                    include = heightToAdd + nextRow[curr_index + 1];
                }
                int exclude = nextRow[prev_index + 1];
                currRow[prev_index + 1] = Math.max(include, exclude);
            }
            nextRow = currRow.clone();
        }

        return currRow[0];
    }

    public static int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        Arrays.sort(cuboids, (a, b) -> Arrays.compare(a, b));

        int ans = solveUsingTabulationSO(cuboids);
        return ans;
    }

    public static void main(String[] args) {
        int cuboids1[][] = { { 50, 45, 20 },
                { 95, 37, 53 },
                { 45, 23, 12 } };
        System.out.println(maxHeight(cuboids1));
        int cuboids2[][] = { { 38, 25, 45 },
                { 76, 35, 3 } };
        System.out.println(maxHeight(cuboids2));
        int cuboids3[][] = { { 7, 11, 17 },
                { 7, 17, 11 },
                { 11, 7, 17 },
                { 11, 17, 7 },
                { 17, 7, 11 },
                { 17, 11, 7 } };
        System.out.println(maxHeight(cuboids3));
    }
}
