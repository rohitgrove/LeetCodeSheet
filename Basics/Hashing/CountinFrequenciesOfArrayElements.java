import java.util.HashMap;

public class CountinFrequenciesOfArrayElements {
    public static void frequency1(int arr[]) {
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maximum = Math.max(maximum, arr[i]);
        }

        int hash[] = new int[maximum + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                System.out.println(i + " " + hash[i]);
            }
        }
        System.out.println();
    }

    public static void frequency2(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 10, 5, 10, 15, 10, 5 };
        frequency2(arr1);
        int arr2[] = { 2, 2, 3, 4, 4, 2 };
        frequency2(arr2);
    }
}
