import java.util.Arrays;

public class WeightedWordMapping {
    public static String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            int total = 0;
            for (char ch : word.toCharArray()) {
                total += weights[ch - 'a'];
            }

            int mod = total % 26;
            char mappedChar = (char) ('z' - mod);
            result.append(mappedChar);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String[] words1 = { "abcd", "def", "xyz" };
        int[] weights1 = { 5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2 };

        System.out.println("Example 1 Output: " + mapWordWeights(words1, weights1));

        String[] words2 = { "a", "b", "c" };
        int[] weights2 = new int[26];
        Arrays.fill(weights2, 1);

        System.out.println("Example 2 Output: " + mapWordWeights(words2, weights2));

        String[] words3 = { "abcd" };
        int[] weights3 = { 7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5 };

        System.out.println("Example 3 Output: " + mapWordWeights(words3, weights3));
    }
}
