public class AddTwoNumbers {
    public static Node addTwoNumbers(Node num1, Node num2) {
        Node ans = new Node(-1);
        Node it = ans;

        int carry = 0;

        while (num1 != null || num2 != null || carry != 0) {
            int val1 = num1 != null ? num1.val : 0;
            int val2 = num2 != null ? num2.val : 0;

            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            Node newNode = new Node(digit);
            it.next = newNode;
            it = it.next;
            num1 = num1 != null ? num1.next : null;
            num2 = num2 != null ? num2.next : null;
        }

        return ans.next;
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("Null");
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        Node head1 = node1;
        node1.next = node2;
        node2.next = node3;
        printLL(head1);

        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(4);
        Node head2 = node4;
        node4.next = node5;
        node5.next = node6;
        printLL(head2);

        printLL(addTwoNumbers(head1, head2));
    }
}
