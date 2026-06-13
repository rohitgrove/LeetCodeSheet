import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void combinationSumHelper(int[] candidates, int target, int sum, List<Integer> curr,
            List<List<Integer>> ans, int index) {
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            curr.add(candidates[i]);
            combinationSumHelper(candidates, target, sum + candidates[i], curr, ans, i + 1);
            curr.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int sum = 0;
        combinationSumHelper(candidates, target, sum, curr, ans, 0);

        return ans;
    }

    public static void main(String[] args) {
        int candidates1[] = { 10, 1, 2, 7, 6, 1, 5 };
        System.out.println(combinationSum(candidates1, 8));
        int candidates2[] = { 2, 5, 2, 1, 2 };
        System.out.println(combinationSum(candidates2, 5));
    }
}
