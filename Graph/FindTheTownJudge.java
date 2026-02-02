import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindTheTownJudge {
    public static int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) {
            return 1;
        }
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] row : trust) {
            int u = row[0];
            int v = row[1];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);
        }

        HashMap<Integer, Integer> indegree = new HashMap<>();

        for (int src : adjList.keySet()) {
            for (int nbr : adjList.get(src)) {
                indegree.putIfAbsent(nbr, 0);
                indegree.put(nbr, indegree.get(nbr) + 1);
            }
        }

        for (int src : indegree.keySet()) {
            if (indegree.get(src) == n - 1 && !adjList.containsKey(src)) {
                return src;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int trust1[][] = { { 1, 2 } };
        System.out.println(findJudge(2, trust1));
        int trust2[][] = { { 1, 3 },
                { 2, 3 } };
        System.out.println(findJudge(3, trust2));
        int trust3[][] = { { 1, 3 },
                { 2, 3 },
                { 3, 1 } };
        System.out.println(findJudge(3, trust3));
    }
}
