public class TwoFurthestHousesWithDifferentColors {
    public static int maxDistance(int[] colors) {
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < colors.length; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    maxDiff = Math.max(maxDiff, Math.abs(i - j));
                }
            }
        }

        return maxDiff;
    }

    public static int maxDistance2(int[] colors) {
        int n = colors.length, i = 0, color = colors[0];

        while (colors[i] == colors[n - 1 - i] && color == colors[i]) {
            i++;
        }

        return n - 1 - i;
    }

    public static void main(String[] args) {
        int colors1[] = { 1, 1, 1, 6, 1, 1, 1 };
        System.out.println(maxDistance2(colors1));
        int colors2[] = { 1, 8, 3, 8, 3 };
        System.out.println(maxDistance2(colors2));
        int colors3[] = { 0, 1 };
        System.out.println(maxDistance2(colors3));
    }
}
