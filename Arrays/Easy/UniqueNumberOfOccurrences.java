import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        HashSet<Integer> s = new HashSet<>();
        for (int x : freq.values()) {
            s.add(x);
        }

        return freq.size() == s.size();
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 2, 1, 1, 3 };
        System.out.println(uniqueOccurrences(arr1));
        int arr2[] = { 1, 2 };
        System.out.println(uniqueOccurrences(arr2));
        int arr3[] = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
        System.out.println(uniqueOccurrences(arr3));
    }
}
