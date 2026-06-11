import java.util.Stack;

public class ReverseAStack {
    public static void insertAtBottom(Stack<Integer> st, int val) {
        if (st.isEmpty()) {
            st.push(val);
            return;
        }

        int temp = st.pop();
        insertAtBottom(st, val);
        st.push(temp);
    }

    public static void reverseAStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int val = st.pop();
        reverseAStack(st);
        insertAtBottom(st, val);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(1);
        st.push(3);
        st.push(2);

        System.out.println(st);
        reverseAStack(st);
        System.out.println(st);
    }
}
