import java.util.ArrayList;
import java.util.List;

public class Subsets1 {
    public static void solve(int[] nums, int idx, List<Integer> currAns, List<List<Integer>> ans) {
        if (idx >= nums.length) {
            ans.add(new ArrayList<>(currAns));
            return;
        }

        currAns.add(nums[idx]);
        solve(nums, idx + 1, currAns, ans);
        currAns.removeLast();
        solve(nums, idx + 1, currAns, ans);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> currAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int idx = 0;
        solve(nums, idx, currAns, ans);

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        System.out.println(subsets(nums));
    }
}
