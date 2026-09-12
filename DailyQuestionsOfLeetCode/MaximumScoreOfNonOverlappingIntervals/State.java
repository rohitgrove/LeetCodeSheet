import java.util.List;

public class State implements Comparable<State> {
    long score;
    List<Integer> indices;

    public State(long score, List<Integer> indices) {
        this.score = score;
        this.indices = indices;
    }

    // compare score first, then compare indices lexicographically
    @Override
    public int compareTo(State other) {
        if (this.score != other.score) {
            return Long.compare(this.score, other.score);
        }
        int len = Math.min(this.indices.size(), other.indices.size());
        for (int i = 0; i < len; i++) {
            int cmp = Integer.compare(this.indices.get(i), other.indices.get(i));
            if (cmp != 0) {
                return cmp;
            }
        }
        return Integer.compare(this.indices.size(), other.indices.size());
    }
}