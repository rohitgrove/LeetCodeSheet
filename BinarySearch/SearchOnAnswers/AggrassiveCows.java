import java.util.Arrays;

public class AggrassiveCows {
    public static boolean isPossible(int[] stalls, int mid, int k) {
        int lastPos = stalls[0];
        int count = 1;

        for (int i = 0; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= mid) {
                count++;
                if (count == k) {
                    return true;
                }
                lastPos = stalls[i];
            }
        }

        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int start = 0;
        int end = stalls[stalls.length - 1];

        int ans = -1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (isPossible(stalls, mid, k)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            mid = start + (end - start) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = { 1, 2, 3 };
        int k1 = 2;
        System.out.println("Test 1 Expected: 2");
        System.out.println(aggressiveCows(arr1, k1));

        // Test Case 2
        int[] arr2 = { 0, 3, 4, 7, 10, 9 };
        int k2 = 4;
        System.out.println("Test 2 Expected: 3");
        System.out.println(aggressiveCows(arr2, k2));

        // Test Case 3
        int[] arr3 = { 4, 2, 1, 3, 6 };
        int k3 = 2;
        System.out.println("Test 3 Expected: 5");
        System.out.println(aggressiveCows(arr3, k3));

        // Test Case 4 -> Minimum n
        int[] arr4 = { 1, 100 };
        int k4 = 2;
        System.out.println("Test 4 Expected: 99");
        System.out.println(aggressiveCows(arr4, k4));

        // Test Case 5 -> All stalls same
        int[] arr5 = { 7, 7, 7, 7, 7 };
        int k5 = 3;
        System.out.println("Test 5 Expected: 0");
        System.out.println(aggressiveCows(arr5, k5));

        // Test Case 6 -> k = n
        int[] arr6 = { 1, 2, 4, 8, 9 };
        int k6 = 5;
        System.out.println("Test 6 Expected: 1");
        System.out.println(aggressiveCows(arr6, k6));

        // Test Case 7 -> Large gaps
        int[] arr7 = { 1, 100, 200, 300, 1000 };
        int k7 = 3;
        System.out.println("Test 7 Expected: 299");
        System.out.println(aggressiveCows(arr7, k7));

        // Test Case 8 -> Unsorted array
        int[] arr8 = { 10, 1, 2, 7, 5, 9 };
        int k8 = 3;
        System.out.println("Test 8 Expected: 4");
        System.out.println(aggressiveCows(arr8, k8));

        // Test Case 9 -> Consecutive positions
        int[] arr9 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int k9 = 3;
        System.out.println("Test 9 Expected: 3");
        System.out.println(aggressiveCows(arr9, k9));

        // Test Case 10
        int[] arr10 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int k10 = 4;
        System.out.println("Test 10 Expected: 2");
        System.out.println(aggressiveCows(arr10, k10));

        // Test Case 11 -> Large values
        int[] arr11 = { 0, 1000000000, 5, 8, 10 };
        int k11 = 2;
        System.out.println("Test 11 Expected: 1000000000");
        System.out.println(aggressiveCows(arr11, k11));

        // Test Case 12
        int[] arr12 = { 1, 2, 4, 8, 9 };
        int k12 = 3;
        System.out.println("Test 12 Expected: 3");
        System.out.println(aggressiveCows(arr12, k12));
    }
}
