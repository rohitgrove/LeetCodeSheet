public class DSU {
    int[] parent;
    int[] rank;
    int components;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean unite(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return false;
        }

        if (rank[pa] < rank[pb]) {
            int temp = pa;
            pa = pb;
            pb = temp;
        }

        parent[pb] = pa;

        if (rank[pa] == rank[pb]) {
            rank[pa]++;
        }

        components--;
        return true;
    }
}
