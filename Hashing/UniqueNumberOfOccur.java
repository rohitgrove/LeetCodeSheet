import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccur {
    public static boolean uniqueOccurrences1(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int ele : arr) {
            count.putIfAbsent(ele, 0);
            count.put(ele, count.get(ele) + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        for (int val : count.values()) {
            if (set.contains(val)) {
                return false;
            }
            set.add(val);
        }

        return true;
    }

    public static boolean uniqueOccurrences2(int[] arr) {
        int[] count = new int[2001];
        for (int num : arr) {
            count[num + 1000]++;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int freq : count) {
            if (freq == 0)
                continue;

            if (set.contains(freq)) {
                return false;
            }
            set.add(freq);
        }

        return true;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 2, 1, 1, 3 };
        System.out.println(uniqueOccurrences2(arr1));
        int arr2[] = { 1, 2 };
        System.out.println(uniqueOccurrences2(arr2));
        int arr3[] = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
        System.out.println(uniqueOccurrences2(arr3));
    }
}