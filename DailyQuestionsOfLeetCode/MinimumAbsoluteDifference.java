import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int currDiff = arr[i + 1] - arr[i];
            minDiff = Math.min(currDiff, minDiff);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff == minDiff) {
                List<Integer> currAns = new ArrayList<>();
                currAns.add(arr[i]);
                currAns.add(arr[i + 1]);
                res.add(currAns);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr1[] = { 4, 2, 1, 3 };
        System.out.println(minimumAbsDifference(arr1));
        int arr2[] = { 1, 3, 6, 10, 15 };
        System.out.println(minimumAbsDifference(arr2));
        int arr3[] = { 3, 8, -10, 23, 19, -4, -14, 27 };
        System.out.println(minimumAbsDifference(arr3));
    }
}
