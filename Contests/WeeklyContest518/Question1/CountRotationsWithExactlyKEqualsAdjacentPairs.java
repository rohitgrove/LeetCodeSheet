public class CountRotationsWithExactlyKEqualsAdjacentPairs {
    public static int countRotations(String s, int k) {
        int n = s.length();

        int equalPairs = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s.charAt((i + 1) % n)) {
                equalPairs++;
            }
        }

        if (k == equalPairs) {
            return n - equalPairs;
        }

        if (k == equalPairs - 1) {
            return equalPairs;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countRotations("aab", 1));
        // Output: 2

        System.out.println(countRotations("abca", 0));
        // Output: 1

        System.out.println(countRotations("aaaa", 3));
        // Output: 4

        System.out.println(countRotations("aaaa", 2));
        // Output: 0

        System.out.println(countRotations("abc", 0));
        // Output: 3

        System.out.println(countRotations("aabb", 1));
        // Output: 2
    }
}
