import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
    public static void solve(List<String> ans, StringBuilder currAns, int idx, String digits, String keyPad[]) {
        if (idx >= digits.length()) {
            ans.add(String.valueOf(currAns));
            return;
        }

        String temp = keyPad[digits.charAt(idx) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            currAns.append(temp.charAt(i));
            solve(ans, currAns, idx + 1, digits, keyPad);
            currAns.deleteCharAt(currAns.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        String keyPad[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        List<String> ans = new ArrayList<>();
        StringBuilder currAns = new StringBuilder();
        solve(ans, currAns, 0, digits, keyPad);
        return ans;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
