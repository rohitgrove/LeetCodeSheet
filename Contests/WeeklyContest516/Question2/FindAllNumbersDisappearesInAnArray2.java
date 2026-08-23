import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearesInAnArray2 {
    public static List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        boolean[] present = new boolean[upper - lower + 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= lower && nums[i] <= upper) {
                present[nums[i] - lower] = true;
            }
        }

        int idx = 0;

        List<List<Integer>> res = new ArrayList<>();
        while (idx < present.length) {
            if (!present[idx]) {
                int start = lower + idx;

                while (idx < present.length && !present[idx]) {
                    idx++;
                }

                int end = lower + idx - 1;

                res.add(Arrays.asList(start, end));
            } else {
                idx++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 9, 7 };
        System.out.println(findDisappearedNumbers(nums1, 1, 12));
        int nums2[] = { 1, 1 };
        System.out.println(findDisappearedNumbers(nums2, 5, 7));
        int nums3[] = { 2, 3, 5 };
        System.out.println(findDisappearedNumbers(nums3, 2, 3));
    }
}
