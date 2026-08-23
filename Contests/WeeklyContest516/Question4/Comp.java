import java.util.Comparator;

public class Comp implements Comparator<Query> {
    private int blockSize;

    public Comp() {
    }

    public Comp(int blockSize) {
        this.blockSize = blockSize;
    }

    @Override
    public int compare(Query o1, Query o2) {
        int blockA = o1.left / blockSize;
        int blockB = o2.left / blockSize;

        if (blockA != blockB) {
            return Integer.compare(blockA, blockB);
        }

        if ((blockA & 1) == 0) {
            return Integer.compare(o1.right, o2.right);
        } else {
            return Integer.compare(o2.right, o1.right);
        }
    }
}
