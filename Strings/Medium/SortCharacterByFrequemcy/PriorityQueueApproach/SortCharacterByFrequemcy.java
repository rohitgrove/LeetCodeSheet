import java.util.PriorityQueue;

public class SortCharacterByFrequemcy {
    public static String frequencySort(String s) {
        char hash[] = new char[256];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comp());
        for (int i = 0; i < s.length(); i++) {
            pq.offer(new Pair(s.charAt(i), hash[s.charAt(i)]));
        }

        StringBuilder str = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            char ch = pair.character;
            
            str.append(ch);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }
}
