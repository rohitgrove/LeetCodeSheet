public class ReverseDegreeOfAString {
    public static int reverseDegree(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = i + 1;
            int prodNum = 'z' - ch + 1;
            int prod = idx * prodNum;
            ans += prod;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverseDegree("abc"));
        System.out.println(reverseDegree("zaza"));
    }
}
