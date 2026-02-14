import java.util.HashMap;

public class NumberOfPreficConnectedGroups {
    public static int prefixConnectedGroups(String[] words, int k) {
        HashMap<String, Integer> prefixCount = new HashMap<>();

        for (String word : words) {
            if (word.length() >= k) {
                String prefix = word.substring(0, k);
                prefixCount.put(prefix, prefixCount.getOrDefault(prefix, 0) + 1);
            }
        }

        int groups = 0;

        for (int count : prefixCount.values()) {
            if (count >= 2) {
                groups++;
            }
        }

        return groups;
    }

    public static void main(String[] args) {
        String[] words1 = { "apple", "apply", "banana", "bandit" };
        int k1 = 2;

        System.out.println("Example 1 Output: " + prefixConnectedGroups(words1, k1));

        String[] words2 = { "car", "cat", "cartoon" };
        int k2 = 3;

        System.out.println("Example 2 Output: " + prefixConnectedGroups(words2, k2));

        String[] words3 = { "bat", "dog", "dog", "doggy", "bat" };
        int k3 = 3;

        System.out.println("Example 3 Output: " + prefixConnectedGroups(words3, k3));
    }
}
