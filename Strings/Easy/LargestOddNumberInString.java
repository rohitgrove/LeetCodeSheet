public class LargestOddNumberInString {
    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int ch = num.charAt(i) - '0';
            if (ch % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
        System.out.println(largestOddNumber("4206"));
        System.out.println(largestOddNumber("35427"));
    }
}
