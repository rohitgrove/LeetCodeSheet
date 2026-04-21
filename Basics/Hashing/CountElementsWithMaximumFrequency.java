import java.util.HashMap;

public class CountElementsWithMaximumFrequency {
    public static int bruteForce(int arr[]) {
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maximum = Math.max(maximum, arr[i]);
        }

        int hash[] = new int[maximum + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        int maxCount = 0;
        for (int i = 0; i < hash.length; i++) {
            maxCount = Math.max(maxCount, hash[i]);
        }

        int ans = 0;
        for (int i = 0; i < hash.length; i++) {
            if (maxCount == hash[i]) {
                ans += maxCount;
            }
        }
        return ans;
    }

    public static int optimizedApproach(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int maxCount = 0;
        for (int key : map.keySet()) {
            maxCount = Math.max(maxCount, map.get(key));
        }

        int ans = 0;
        for (int key : map.keySet()) {
            if (maxCount == map.get(key)) {
                ans += maxCount;
            }
        }

        return ans;
    }

    public static int maxFrequencyElements(int[] nums) {
        return optimizedApproach(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 2, 3, 1, 4 };
        System.out.println(maxFrequencyElements(nums1));
        int nums2[] = { 1, 2, 3, 4, 5 };
        System.out.println(maxFrequencyElements(nums2));
    }
}
