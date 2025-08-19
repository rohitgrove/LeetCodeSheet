import java.util.Stack;

public class DeleteMiddleElementOfStack {
    public static void deleteFromMid(Stack<Integer> st, int pos) {
        if (pos == 1) {
            st.pop();
            return;
        }

        int element = st.pop();

        deleteFromMid(st, pos - 1);

        st.push(element);
    }

    public static void deleteMid(Stack<Integer> st) {
        int size = st.size();
        // stack is not empty
        // odd
        int pos = size / 2 + 1;

        deleteFromMid(st, pos);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        System.out.println(st);
        deleteMid(st);
        System.out.println(st);
    }
}
