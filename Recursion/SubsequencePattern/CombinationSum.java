import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void combinationSumHelper(int[] candidates, int target, int sum, List<Integer> curr, List<List<Integer>> ans, int index) {
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            curr.add(candidates[i]);
            combinationSumHelper(candidates, target, sum + candidates[i], curr, ans, i);
            curr.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int sum = 0;
        combinationSumHelper(candidates, target, sum, curr, ans, 0);

        return ans;
    }

    public static void main(String[] args) {
        int candidates1[] = { 2, 3, 6, 7 };
        System.out.println(combinationSum(candidates1, 7));
        int candidates2[] = { 2, 3, 5 };
        System.out.println(combinationSum(candidates2, 8));
    }
}
