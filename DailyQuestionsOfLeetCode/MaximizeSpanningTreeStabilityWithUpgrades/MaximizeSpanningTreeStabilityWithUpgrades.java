public class MaximizeSpanningTreeStabilityWithUpgrades {
    public static boolean canAchieve(int n, int[][] edges, int k, int x) {
        DSU dsu = new DSU(n);
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 1) {
                if (s < x) {
                    return false;
                }
                if (!dsu.unite(u, v)) {
                    return false;
                }
            }
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 0 && s >= x) {
                dsu.unite(u, v);
            }
        }

        int usedUpgrades = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 0 && s < x && 2 * s >= x) {
                if (dsu.unite(u, v)) {
                    usedUpgrades++;
                    if (usedUpgrades > k) {
                        return false;
                    }
                }
            }
        }

        return dsu.components == 1;
    }

    public static int maxStability(int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);

        for (int[] e : edges) {
            if (e[3] == 1) {
                if (!dsu.unite(e[0], e[1])) {
                    return -1;
                }
            }
        }

        int low = 1, high = 200000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAchieve(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int edges1[][] = { { 0, 1, 2, 1 },
                { 1, 2, 3, 0 } };
        System.out.println(maxStability(3, edges1, 1));
        int edges2[][] = { { 0, 1, 4, 0 },
                { 1, 2, 3, 0 },
                { 0, 2, 1, 0 } };
        System.out.println(maxStability(3, edges2, 2));
        int edges3[][] = { { 0, 1, 1, 1 },
                { 1, 2, 1, 1 },
                { 2, 0, 1, 1 } };
        System.out.println(maxStability(3, edges3, 0));
    }
}
