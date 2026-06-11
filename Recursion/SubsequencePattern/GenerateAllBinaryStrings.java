import java.util.ArrayList;

public class GenerateAllBinaryStrings {
    public static void genrate(int n, String res, ArrayList<String> ans) {
        if (res.length() == n) {
            ans.add(res);
            return;
        }

        genrate(n, res + "0", ans);

        if (res.isEmpty() || res.charAt(res.length() - 1) != 1) {
            genrate(n, res + "1", ans);
        }
    }

    public static ArrayList<String> binstr(int n) {
        ArrayList<String> ans = new ArrayList<>();
        genrate(n, "", ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(binstr(3));
        System.out.println(binstr(2));
    }
}
