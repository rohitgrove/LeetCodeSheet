public class MinimumBishopMovesToReachTarget {
    public static int minBishopMoves(int[] source, int[] target) {
        int sourceRow = source[0];
        int sourceCol = source[1];

        int targetRow = target[0];
        int targetCol = target[1];

        if (sourceCol == targetCol && sourceRow == targetRow) {
            return 0;
        }

        if ((targetRow + targetCol) % 2 != (sourceRow + sourceCol) % 2) {
            return -1;
        }

        if (Math.abs(sourceCol - targetCol) == Math.abs(sourceRow - targetRow)) {
            return 1;
        }

        return 2;
    }

    public static void main(String[] args) {
        int source1[] = { 8, 1 }, target1[] = { 1, 8 };
        System.out.println(minBishopMoves(source1, target1));
        int source2[] = { 4, 2 }, target2[] = { 1, 3 };
        System.out.println(minBishopMoves(source2, target2));
        int source3[] = { 1, 1 }, target3[] = { 3, 4 };
        System.out.println(minBishopMoves(source3, target3));
    }
}
