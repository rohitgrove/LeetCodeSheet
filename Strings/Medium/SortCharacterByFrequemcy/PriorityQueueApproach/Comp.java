import java.util.Comparator;

public class Comp implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        if (o1.count == o2.count) {
            return o1.character - o2.character;
        } else {
            return o2.count - o1.count;
        }
    }
}
