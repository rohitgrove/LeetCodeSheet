import java.util.*;

public class PalindormicPathQueriesInATree {
    public static List<Integer>[] tree;
    public static int[] parent, depth, heavy, head, pos, size;
    public static int currentPos;
    public static int[] segTree;
    public static int n;
    public static char[] s;
    public static int[] nodeAtPos;

    public static List<Boolean> palindromePath(int nNodes, int[][] edges, String str, String[] queries) {
        n = nNodes;
        s = str.toCharArray();

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++)
            tree[i] = new ArrayList<>();

        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        size = new int[n];
        Arrays.fill(heavy, -1);

        dfs(0, -1);

        head = new int[n];
        pos = new int[n];
        nodeAtPos = new int[n];
        currentPos = 0;

        decompose(0, 0);

        segTree = new int[4 * n];
        build(1, 0, n - 1);

        List<Boolean> result = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {

                int node = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                s[node] = c;
                update(1, 0, n - 1, pos[node]);

            } else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int mask = queryPath(u, v);

                boolean canFormPalindrome = (mask & (mask - 1)) == 0;
                result.add(canFormPalindrome);
            }
        }

        return result;
    }

    public static int dfs(int u, int p) {
        parent[u] = p;
        size[u] = 1;
        int maxSize = 0;

        for (int v : tree[u]) {
            if (v == p)
                continue;

            depth[v] = depth[u] + 1;
            int subSize = dfs(v, u);
            size[u] += subSize;

            if (subSize > maxSize) {
                maxSize = subSize;
                heavy[u] = v;
            }
        }
        return size[u];
    }

    public static void decompose(int u, int h) {

        head[u] = h;
        pos[u] = currentPos;
        nodeAtPos[currentPos] = u;
        currentPos++;

        if (heavy[u] != -1) {
            decompose(heavy[u], h);
        }

        for (int v : tree[u]) {
            if (v != parent[u] && v != heavy[u]) {
                decompose(v, v);
            }
        }
    }

    public static void build(int node, int start, int end) {

        if (start == end) {
            int originalNode = nodeAtPos[start];
            segTree[node] = 1 << (s[originalNode] - 'a');
        } else {
            int mid = (start + end) / 2;

            build(node * 2, start, mid);
            build(node * 2 + 1, mid + 1, end);

            segTree[node] = segTree[node * 2] ^ segTree[node * 2 + 1];
        }
    }

    public static void update(int node, int start, int end, int idx) {

        if (start == end) {
            int originalNode = nodeAtPos[start];
            segTree[node] = 1 << (s[originalNode] - 'a');
        } else {

            int mid = (start + end) / 2;

            if (idx <= mid)
                update(node * 2, start, mid, idx);
            else
                update(node * 2 + 1, mid + 1, end, idx);

            segTree[node] = segTree[node * 2] ^ segTree[node * 2 + 1];
        }
    }

    public static int query(int node, int start, int end, int l, int r) {

        if (r < start || end < l)
            return 0;

        if (l <= start && end <= r)
            return segTree[node];

        int mid = (start + end) / 2;

        return query(node * 2, start, mid, l, r)
                ^ query(node * 2 + 1, mid + 1, end, l, r);
    }

    public static int queryPath(int u, int v) {

        int result = 0;

        while (head[u] != head[v]) {

            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }

            result ^= query(1, 0, n - 1, pos[head[u]], pos[u]);
            u = parent[head[u]];
        }

        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        result ^= query(1, 0, n - 1, pos[u], pos[v]);

        return result;
    }

    public static void main(String[] args) {

        int n1 = 3;
        int[][] edges1 = { { 0, 1 },
                { 1, 2 } };
        String s1 = "aac";
        String[] queries1 = { "query 0 2", "update 1 b", "query 0 2" };

        System.out.println(palindromePath(n1, edges1, s1, queries1));

        int n2 = 4;
        int[][] edges2 = { { 0, 1 },
                { 0, 2 },
                { 0, 3 } };
        String s2 = "abca";
        String[] queries2 = { "query 1 2", "update 0 b", "query 2 3", "update 3 a", "query 1 3" };

        System.out.println(palindromePath(n2, edges2, s2, queries2));
    }
}
