public class ReverseAnArray {
    public static void solveUsingRec(int[] s, int start, int end) {
        if (start > end) {
            return;
        }

        int temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        solveUsingRec(s, start + 1, end - 1);
    }

    public static void reverseArray(int[] s) {
        int start = 0;
        int end = s.length - 1;

        solveUsingRec(s, start, end);
    }

    public static void printArr(int[] s) {
        for (int ch : s) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int s1[] = { 1, 4, 3, 2, 6, 5 };
        reverseArray(s1);
        printArr(s1);
        int s2[] = { 4, 5, 2 };
        reverseArray(s2);
        printArr(s2);
    }
}
