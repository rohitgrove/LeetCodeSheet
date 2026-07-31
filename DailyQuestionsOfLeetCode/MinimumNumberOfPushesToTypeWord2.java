import java.util.Arrays;

public class MinimumNumberOfPushesToTypeWord2 {
    public static int minimumPushes(String word) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i);
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);
        int ans = 0;
        for (int i = 25; i >= 0 && freq[i] > 0; i--) {
            ans += freq[i] * ((25 - i) / 8 + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumPushes("abcde"));
        System.out.println(minimumPushes("xyzxyzxyzxyz"));
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}