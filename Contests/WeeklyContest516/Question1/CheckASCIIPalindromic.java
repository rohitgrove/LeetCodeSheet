public class CheckASCIIPalindromic {
    public static boolean isPalindromic(String s) {
        StringBuilder binary = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int ascii = (int) ch;

            String bits = Integer.toBinaryString(ascii);

            while (bits.length() < 8) {
                bits = "0" + bits;
            }

            binary.append(bits);
        }

        int i = 0;
        int j = binary.length() - 1;

        while (i < j) {
            if (binary.charAt(i) != binary.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromic("ff"));
        System.out.println(isPalindromic("leet"));
    }
}
