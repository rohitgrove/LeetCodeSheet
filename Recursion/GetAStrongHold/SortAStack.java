import java.util.Stack;

public class SortAStack {
    public static void insertInStack(Stack<Integer> st, int temp) {
        if (st.isEmpty() || st.peek() <= temp) {
            st.push(temp);
            return;
        }

        int val = st.pop();
        insertInStack(st, temp);
        st.push(val);
    }

    public static void sortAStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int temp = st.pop();
        sortAStack(st);
        insertInStack(st, temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(1);
        st.push(3);
        st.push(2);
        System.out.println(st);
        sortAStack(st);
        System.out.println(st);
    }
}
