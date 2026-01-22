import java.util.ArrayList;
import java.util.List;

public class MinimumPairRemovalToSortArray1 {
    public static boolean isSorted(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }

        int op = 0;

        while (!isSorted(arr)) {
            int minSum = Integer.MAX_VALUE;
            int index = 0;

            for (int i = 0; i < arr.size() - 1; i++) {
                int sum = arr.get(i) + arr.get(i + 1);

                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }
            arr.remove(index + 1);
            arr.remove(index);
            arr.add(index, minSum);
            op++;
        }

        return op;
    }

    public static void main(String[] args) {
        int nums1[] = { 5, 2, 3, 1 };
        System.out.println(minimumPairRemoval(nums1));
        int nums2[] = { 1, 2, 2 };
        System.out.println(minimumPairRemoval(nums2));
    }
}
