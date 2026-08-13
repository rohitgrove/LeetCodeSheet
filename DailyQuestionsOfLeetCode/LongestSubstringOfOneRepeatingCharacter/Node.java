public class Node {
    public int len, pref, suff, best;
    public char left, right;

    public Node(int len, int pref, int suff, int best, char left, char right) {
        this.len = len;
        this.pref = pref;
        this.suff = suff;
        this.best = best;
        this.left = left;
        this.right = right;
    }
}