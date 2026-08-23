import java.util.ArrayList;
import java.util.List;

public class PrintAllDivisors {
    public static List<Integer> printAllDiv(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static List<Integer> printAllDivOptimal(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                ans.add(i);

                if (i != n / i) {
                    ans.add(n / i);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(printAllDiv(36));
        System.out.println(printAllDiv(12));
        System.out.println(printAllDivOptimal(36));
        System.out.println(printAllDivOptimal(12));
    }
}
