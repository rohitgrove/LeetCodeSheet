import java.util.ArrayList;

public class SumOfBeautyOfAllSubstringsBruteForce {
    public static int beautySum(String s) {
        return count(fun(s));
    }

    public static int count(ArrayList<String> list) {
        int ans = 0;
        for (String str : list) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int[] freq = new int[26];
            for (int i = 0; i < str.length(); i++) {
                freq[str.charAt(i) - 'a']++;
            }
            for (int f : freq) {
                if (f > 0) {
                    min = Math.min(min, f);
                    max = Math.max(max, f);
                }
            }
            ans += (max - min);

        }
        return ans;
    }

    public static ArrayList<String> fun(String s) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (j - i >= 3) {
                    list.add(s.substring(i, j));
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
        System.out.println(beautySum("aabcbaa"));
    }
}
