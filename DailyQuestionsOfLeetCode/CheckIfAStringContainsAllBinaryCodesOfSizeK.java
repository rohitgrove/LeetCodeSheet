import java.util.HashSet;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public static boolean hasAllCodes(String s, int k) {
        HashSet<String> st = new HashSet<>();

        for (int i = 0; i + k <= s.length(); i++) {
            st.add(s.substring(i, i + k));
        }

        System.out.println(st);

        return st.size() == (int) Math.pow(2, k);
    }

    public static void main(String[] args) {
        System.out.println(hasAllCodes("00110110", 2));
        System.out.println(hasAllCodes("0110", 1));
        System.out.println(hasAllCodes("0110", 2));
    }
}
