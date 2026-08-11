public class AddOnToANumber {
    public static Node reverseList(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static Node addOne(Node head) {
        head = reverseList(head);

        Node curr = head;
        int carry = 1;

        while (curr.next != null) {
            int sum = curr.data + carry;
            int digit = sum % 10;
            carry = sum / 10;

            curr.data = digit;
            curr = curr.next;

            if (carry == 0) {
                break;
            }
        }

        if (carry != 0) {
            int sum = curr.data + carry;
            int digit = sum % 10;
            carry = sum / 10;

            curr.data = digit;
            if (carry != 0) {
                Node newNode = new Node(carry);
                curr.next = newNode;
            }
        }

        head = reverseList(head);

        return head;
    }

    public static void main(String[] args) {
        Node first = new Node(9);
        Node second = new Node(9);
        Node third = new Node(9);

        Node head = first;
        first.next = second;
        second.next = third;

        LinkedList.printLL(head);
        LinkedList.printLL(addOne(head));
    }
}
