public class RomanToInteger {
    public static int romanToInt(String s) {
        String romanSymbols[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        int values[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        int res = 0;
        int i = 0;

        while (i < s.length()) {
            for (int j = 0; j < romanSymbols.length; j++) {
                if (s.startsWith(romanSymbols[j], i)) {
                    res += values[j];
                    i += romanSymbols[j].length();
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
