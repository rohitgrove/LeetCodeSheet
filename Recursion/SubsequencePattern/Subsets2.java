import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public static void solve(int[] nums, int idx, List<Integer> currAns, List<List<Integer>> result) {
        result.add(new ArrayList<>(currAns));
        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i - 1]) {
                continue;
            }
            currAns.add(nums[i]);
            solve(nums, i + 1, currAns, result);
            currAns.removeLast();
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, currAns, result);
        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 2 };
        System.out.println(subsetsWithDup(nums));
    }
}
