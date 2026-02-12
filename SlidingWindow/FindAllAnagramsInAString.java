import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public static boolean isAnagram(String s, String t) {
        int freqTable[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freqTable[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            freqTable[t.charAt(i)]--;
        }

        for (int i = 0; i < freqTable.length; i++) {
            if (freqTable[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int start = 0;
        int end = p.length();

        List<Integer> ans = new ArrayList<>();
        while (end <= s.length()) {
            if (isAnagram(s.substring(start, end), p)) {
                ans.add(start);
            }
            start++;
            end++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }
}
