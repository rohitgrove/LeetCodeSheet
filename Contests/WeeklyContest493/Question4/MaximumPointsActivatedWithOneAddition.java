import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MaximumPointsActivatedWithOneAddition {
    public static int maxActivated(int[][] points) {
        int[][] relqavindo = points;
        int n = relqavindo.length;

        if (n == 0) {
            return 1;
        }

        DSU dsu = new DSU();
        int yOffset = 2000000001;

        for (int[] p : relqavindo) {
            dsu.union(p[0], p[1] + yOffset);
        }

        HashMap<Integer, Integer> componentPointCount = new HashMap<>();
        for (int[] p : relqavindo) {
            int root = dsu.find(p[0]);
            componentPointCount.put(root, componentPointCount.getOrDefault(root, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(componentPointCount.values());
        Collections.sort(counts, Collections.reverseOrder());

        if (counts.size() == 1) {
            return counts.get(0) + 1;
        }

        return counts.get(0) + counts.get(1) + 1;
    }

    public static void main(String[] args) {
        int[][] p1 = { { 1, 1 },
                { 1, 2 },
                { 2, 2 } };
        System.out.println(maxActivated(p1));

        int[][] p2 = { { 2, 2 },
                { 1, 1 },
                { 3, 3 } };
        System.out.println(maxActivated(p2));

        int[][] p3 = { { 2, 3 },
                { 2, 2 },
                { 1, 1 },
                { 4, 5 } };
        System.out.println(maxActivated(p3));
    }
}