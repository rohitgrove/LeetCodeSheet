public class SumOfBeautyOfAllSubstringsOptimizedApproach {
    public static int beautySum(String s) {
        return count(s);
    }

    public static int count(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int f : freq) {
                    if (f > 0) {
                        min = Math.min(min, f);
                        max = Math.max(max, f);
                    }
                }
                ans += (max - min);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
        System.out.println(beautySum("aabcbaa"));
    }
}
