import java.util.Stack;

public class ValidStackSequence {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> st = new Stack<>();

        int j = 0;

        for (int i = 0; i < pushed.length; i++) {
            st.push(pushed[i]);

            while (!st.isEmpty() && j < n && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }

        return j == n;
    }

    public static void main(String[] args) {
        int pushed1[] = { 1, 2, 3, 4, 5 }, popped1[] = { 4, 5, 3, 2, 1 };
        System.out.println(validateStackSequences(pushed1, popped1));
        int pushed2[] = { 1, 2, 3, 4, 5 }, popped2[] = { 4, 3, 5, 1, 2 };
        System.out.println(validateStackSequences(pushed2, popped2));
    }
}
