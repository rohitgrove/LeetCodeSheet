public class ReverseString {
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void printArr(char[] s) {
        for (char ch : s) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char s1[] = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(s1);
        printArr(s1);
        char s2[] = { 'H', 'a', 'n', 'n', 'a', 'h' };
        reverseString(s2);
        printArr(s2);
    }
}
