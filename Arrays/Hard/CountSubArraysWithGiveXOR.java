import java.util.HashMap;

public class CountSubArraysWithGiveXOR {
    public static long bruteForce(int arr[], int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int optimizedApproach(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int prefixXor = 0;
        int count = 0;

        for (int num : arr) {
            prefixXor ^= num;

            int target = prefixXor ^ k;
            if (freq.containsKey(target)) {
                count += freq.get(target);
            }

            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }

    public static long subarrayXor(int arr[], int k) {
        return optimizedApproach(arr, k);
    }

    public static void main(String[] args) {
        int arr1[] = { 4, 2, 2, 6, 4 };
        System.out.println(subarrayXor(arr1, 6));
        int arr2[] = { 5, 6, 7, 8, 9 };
        System.out.println(subarrayXor(arr2, 5));
        int arr3[] = { 1, 1, 1, 1 };
        System.out.println(subarrayXor(arr3, 0));
    }
}
