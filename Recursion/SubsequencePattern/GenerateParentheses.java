import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void solve(int open, int close, List<String> ans, String curr) {
        if (open < 0 || close < 0 || open > close) {
            return;
        }

        if (open == 0 && close == 0) {
            ans.add(curr);
            return;
        }

        solve(open - 1, close, ans, curr + "(");
        solve(open, close - 1, ans, curr + ")");
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, n, ans, "");
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(1));
    }
}
