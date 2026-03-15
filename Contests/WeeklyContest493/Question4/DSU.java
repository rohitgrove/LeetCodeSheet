import java.util.HashMap;

public class DSU {
    HashMap<Integer, Integer> parent = new HashMap<>();

    public int find(int i) {
        if (!parent.containsKey(i)) {
            parent.put(i, i);
            return i;
        }
        if (parent.get(i) == i) {
            return i;
        }
        int root = find(parent.get(i));
        parent.put(i, root);
        return root;
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent.put(rootI, rootJ);
        }
    }
}