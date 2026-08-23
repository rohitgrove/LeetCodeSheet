import java.util.*;

public class FindTheHighestLowestFrequencyElement {
    public static void maxFrequency(int arr[]) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores element -> frequency

        // Count frequencies
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int maxFreq = 0, minFreq = n;
        int maxEle = 0, minEle = 0;

        // Traverse map to find min and max frequency elements
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            if (count > maxFreq) {
                maxFreq = count;
                maxEle = element;
            }

            if (count < minFreq) {
                minFreq = count;
                minEle = element;
            }
        }

        // Print results
        System.out.println("The highest frequency element is: " + maxEle);
        System.out.println("The lowest frequency element is: " + minEle);
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 5, 10, 15, 10, 5 };
        maxFrequency(nums1);
        int nums2[] = { 2, 2, 3, 4, 4, 2 };
        maxFrequency(nums2);
    }
}
