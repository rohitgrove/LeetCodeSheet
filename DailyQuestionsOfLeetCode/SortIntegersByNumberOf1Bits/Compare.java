import java.util.Comparator;

public class Compare implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        if (o1.count == o2.count) {
            return o1.element - o2.element;
        } else {
            return o1.count - o2.count;
        }
    }
}
