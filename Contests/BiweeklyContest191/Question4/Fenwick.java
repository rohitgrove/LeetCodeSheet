public class Fenwick {
    public long[] tree;
    public Fenwick(int n) {
        tree = new long[n + 1];
    }

    public void add(int index, long value) {
        while (index < tree.length) {
            tree[index] += value;
            index += index & -index;
        }
    }

    public long query(int index) {
        long sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }

        return sum;
    }
}