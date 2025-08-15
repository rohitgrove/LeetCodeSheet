public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        String strs[] = s.trim().split("\\s+");

        int start = 0;
        int end = strs.length - 1;

        while (start < end) {
            String temp = strs[start];
            strs[start] = strs[end];
            strs[end] = temp;
            start++;
            end--;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < strs.length - 1; i++) {
            String word = strs[i] + " ";
            ans.append(word);
        }

        ans.append(strs[strs.length - 1]);

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords("a good   example"));
    }
}
