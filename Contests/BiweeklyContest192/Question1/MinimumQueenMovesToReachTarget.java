public class MinimumQueenMovesToReachTarget {
    public static int minQueenMoves(int[] source, int[] target) {
        int sr = source[0], sc = source[1];
        int tr = target[0], tc = target[1];

        if (sr == tr && sc == tc) {
            return 0;
        }

        if (sr == tr || sc == tc || Math.abs(sr - tr) == Math.abs(sc - tc)) {
            return 1;
        }

        return 2;
    }

    public static void main(String[] args) {
        int[] source1 = { 8, 1 };
        int[] target1 = { 1, 8 };
        System.out.println(minQueenMoves(source1, target1));

        int[] source2 = { 4, 2 };
        int[] target2 = { 1, 3 };
        System.out.println(minQueenMoves(source2, target2));

        int[] source3 = { 1, 1 };
        int[] target3 = { 1, 1 };
        System.out.println(minQueenMoves(source3, target3));
    }
}