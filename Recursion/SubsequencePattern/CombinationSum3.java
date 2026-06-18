import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void solve(int start, int k, int n, int sum, List<List<Integer>> ans, List<Integer> currAns) {
        if (n < sum) {
            return;
        }

        if (currAns.size() == k) {
            if (n == sum) {
                ans.add(new ArrayList<>(currAns));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            currAns.add(i);
            solve(i + 1, k, n, sum + i, ans, currAns);
            currAns.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int sum = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();

        solve(1, k, n, sum, ans, currAns);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(4, 1));
    }
}
