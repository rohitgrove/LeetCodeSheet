import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void solve(List<List<String>> ans, List<String> currRes, int idx, String s) {
        if (idx >= s.length()) {
            ans.add(new ArrayList<>(currRes));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String subString = s.substring(idx, i + 1);
            if (isPalindrome(s, idx, i)) {
                currRes.add(subString);
                solve(ans, currRes, i + 1, s);
                currRes.remove(currRes.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> currRes = new ArrayList<>();

        solve(ans, currRes, 0, s);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("a"));
    }
}
