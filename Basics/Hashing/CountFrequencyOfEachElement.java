import java.util.HashMap;

public class CountFrequencyOfEachElement {
    public static void frequencyBruteForce(int arr[]) {
        int largest = 0;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(arr[i], largest);
        }

        int freq[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                System.out.print(i + " : " + freq[i] + ", ");
            }
        }
        System.out.println();
    }

    public static void frequencyOptimized(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(map);
    }

    public static void main(String[] args) {
        int arr1[] = { 10, 5, 10, 15, 10, 5 };
        frequencyBruteForce(arr1);
        frequencyOptimized(arr1);
        int arr2[] = { 2, 2, 3, 4, 4, 2 };
        frequencyBruteForce(arr2);
        frequencyOptimized(arr2);
    }
}
