import java.util.Stack;

public class SortAStack {
    public static void insertInASortedStack(Stack<Integer> st, int data) {
        if (st.isEmpty() || st.peek() < data) {
            st.push(data);
            return;
        }

        int element = st.pop();

        insertInASortedStack(st, data);

        st.push(element);
    }

    public static void sortAStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int element = st.pop();

        sortAStack(st);

        insertInASortedStack(st, element);
    }

    public static Stack<Integer> sort(Stack<Integer> st) {
        sortAStack(st);

        return st;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(11);
        st.push(2);
        st.push(32);
        st.push(3);
        st.push(41);

        System.out.println(sort(st));
    }
}
