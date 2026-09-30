import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {
    public static boolean checkPerfectNumber(int num) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                // num khud ko add nahi karna
                if (i != num) {
                    ans.add(i);
                }

                int divisor = num / i;

                // duplicate divisor aur num ko add nahi karna
                if (divisor != i && divisor != num) {
                    ans.add(divisor);
                }
            }
        }

        int sum = 0;

        for (Integer number : ans) {
            sum += number;
        }
        return num == sum;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
        System.out.println(checkPerfectNumber(7));
        System.out.println(checkPerfectNumber(36));
    }
}