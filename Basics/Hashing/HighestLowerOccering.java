import java.util.HashMap;

public class HighestLowerOccering {
    public static int[] Frequency(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores element -> frequency

        // Count frequencies
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int maxFreq = 0, minFreq = n;
        int maxEle = 0, minEle = 0;

        // Traverse map to find min and max frequency elements
        for (int key : map.keySet()) {
            int element = key;
            int count = map.get(key);

            if (count > maxFreq) {
                maxFreq = count;
                maxEle = element;
            }

            if (count < minFreq) {
                minFreq = count;
                minEle = element;
            }
        }

        int ans[] = { maxEle, minEle };

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 5, 10, 15, 10, 5 };
        int ans[] = Frequency(arr, arr.length);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
