import java.util.Arrays;

public class CountNumberOfSubstring {
    public static int numberOfSubstrings(String s) {
        int abc[] = new int[3];
        Arrays.fill(abc, -1);
        int count = 0;
        int right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            abc[ch - 'a'] = right;
            int minIndex = Integer.MAX_VALUE;
            for (int i = 0; i < abc.length; i++) {
                minIndex = Math.min(minIndex, abc[i]);
            }

            count += (minIndex + 1);
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaabc"));
        System.out.println(numberOfSubstrings("abc"));
    }
}
