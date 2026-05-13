import java.util.Arrays;

public class SortCharacterByFrequemcy {
    public static String frequencySort(String s) {
        // ASCII characters ke liye 256 size
        Pair[] freq = new Pair[256];

        // Initialize
        for (int i = 0; i < 256; i++) {
            freq[i] = new Pair((char) i, 0);
        }

        // Frequency count
        for (char ch : s.toCharArray()) {
            freq[ch].count++;
        }

        // Sort by frequency descending
        // Agar frequency same ho toh character ascending
        Arrays.sort(freq, new Comp());

        // Store result
        StringBuilder res = new StringBuilder();

        for (Pair p : freq) {
            while (p.count > 0) {
                res.append(p.character);
                p.count--;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }
}
