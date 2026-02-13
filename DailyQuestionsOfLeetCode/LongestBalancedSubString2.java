import java.util.HashMap;

public class LongestBalancedSubString2 {
    public static int longestBalanced(String s) {
        int maxi = 0;
        maxi = Math.max(maxi, solve(s, 1));
        maxi = Math.max(maxi, solve(s, 2));
        maxi = Math.max(maxi, solve(s, 3));
        maxi = Math.max(maxi, solve(s, 4));
        maxi = Math.max(maxi, single(s, 'a'));
        maxi = Math.max(maxi, single(s, 'b'));
        maxi = Math.max(maxi, single(s, 'c'));
        return maxi;
    }

    public static int solve(String s, int type) {
        HashMap<String, Integer> map = new HashMap<>();
        int a = 0;
        int b = 0;
        int c = 0;
        int maxi = 0;
        String initial = generate(0, 0, 0, type);
        map.put(initial, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                a++;
            } else if (ch == 'b') {
                b++;
            } else {
                c++;
            }
            String encode = generate(a, b, c, type);
            if (map.containsKey(encode)) {
                maxi = Math.max(maxi, i - map.get(encode));
            } else {
                map.put(encode, i);
            }
        }
        return maxi;
    }

    public static String generate(int a, int b, int c, int type) {
        return switch (type) {
            case 1 -> (a - b) + "#" + (b - c);
            case 2 -> (a - b) + "#" + c;
            case 3 -> (a - c) + "#" + b;
            case 4 -> (b - c) + "#" + a;
            default -> "";
        };
    }

    public static int single(String s, char target) {
        int maxi = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) != target) {
                i++;
                continue;
            }
            int j = i;
            while (j < n && s.charAt(j) == target)
                j++;
            maxi = Math.max(maxi, j - i);
            i = j;
        }
        return maxi;
    }

    public static void main(String[] args) {
        System.out.println(longestBalanced("abbac"));
        System.out.println(longestBalanced("aabcc"));
        System.out.println(longestBalanced("aba"));
    }
}