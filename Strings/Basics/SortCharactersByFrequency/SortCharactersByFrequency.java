import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        int freq[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                pq.offer(new Pair((char) i, freq[i]));
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            char ch = top.ch;
            int count = top.freq;
            while (count != 0) {
                ans.append(ch);
                count--;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }
}
