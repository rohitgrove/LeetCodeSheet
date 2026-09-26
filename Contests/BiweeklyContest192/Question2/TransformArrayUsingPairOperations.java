public class TransformArrayUsingPairOperations {
    public static boolean canTransform(int[] source, int[] target) {
        long sumSource = 0;
        long sumTarget = 0;

        for (int x : source) {
            sumSource += x;
        }

        for (int x : target) {
            sumTarget += x;
        }

        return sumSource == sumTarget;
    }

    public static void main(String[] args) {
        int[] source1 = { 1, 2, 3 };
        int[] target1 = { 0, 2, 4 };
        System.out.println(canTransform(source1, target1));

        int[] source2 = { -5, -5 };
        int[] target2 = { -15, 5 };
        System.out.println(canTransform(source2, target2));

        int[] source3 = { 1, 2, 1 };
        int[] target3 = { 0, 2, 5 };
        System.out.println(canTransform(source3, target3));

        int[] source4 = { 1, 2, 3 };
        int[] target4 = { 1, 3, 3 };
        System.out.println(canTransform(source4, target4));
    }
}
