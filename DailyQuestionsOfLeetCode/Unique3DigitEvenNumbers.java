import java.util.HashSet;
import java.util.Set;

public class Unique3DigitEvenNumbers {
    public static int totalNumbers(int[] digits) {
        Set<Integer> seen = new HashSet<>();
        int n = digits.length;

        for (int h = 0; h < n; h++) {
            if (digits[h] == 0) continue;

            for (int t = 0; t < n; t++) {
                if (t == h) continue;

                for (int u = 0; u < n; u++) {
                    if (u == h || u == t) continue;

                    if (digits[u] % 2 != 0) continue;

                    int num = digits[h] * 100 + digits[t] * 10 + digits[u];
                    seen.add(num);
                }
            }
        }

        return seen.size();
    }

    public static void main(String[] args) {
        int digits1[] = { 1, 2, 3, 4 };
        System.out.println(totalNumbers(digits1));
        int digits2[] = { 0, 2, 2 };
        System.out.println(totalNumbers(digits2));
        int digits3[] = { 6, 6, 6 };
        System.out.println(totalNumbers(digits3));
        int digits4[] = { 1, 3, 5 };
        System.out.println(totalNumbers(digits4));
    }
}
