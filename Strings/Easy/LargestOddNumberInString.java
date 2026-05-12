public class LargestOddNumberInString {
    public static String largestOddNumber(String num) {
        int idx = -1;
        // Find the last odd digit in the string
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                idx = i;
                break;
            }
        }

        // Return empty string if no odd digit was found
        if (idx == -1) {
            return "";
        }

        // Skip leading zeroes up to the odd digit
        int i = 0;
        while (i < idx && num.charAt(i) == '0') {
            i++;
        }

        // Return substring from first non-zero to odd digit
        return num.substring(i, idx + 1);
    }

    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
        System.out.println(largestOddNumber("4206"));
        System.out.println(largestOddNumber("35427"));
    }
}
