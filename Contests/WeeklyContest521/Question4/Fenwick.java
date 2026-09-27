import java.util.Arrays;

public class Fenwick {
    public long[] tree;

    public Fenwick(int n) {
        tree = new long[n + 1];
        Arrays.fill(tree, Long.MIN_VALUE / 4);
    }

    public void update(int index, long value) {
        while (index < tree.length) {
            tree[index] = Math.max(tree[index], value);
            index += index & -index;
        }
    }

    public long query(int index) {
        long result = Long.MIN_VALUE / 4;

        while (index > 0) {
            result = Math.max(result, tree[index]);
            index -= index & -index;
        }

        return result;
    }
}