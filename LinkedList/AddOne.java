public class AddOne {
    public static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public static Node addOne(Node head) {
        // reverse
        head = reverseLL(head);
        // add1
        int carry = 1;
        Node temp = head;
        while (temp.next != null) {
            int totalSum = temp.val + carry;
            int digit = totalSum % 10;
            carry = totalSum / 10;

            temp.val = digit;
            temp = temp.next;
            if (carry == 0) {
                break;
            }
        }

        // process Last Node
        if (carry != 0) {
            int totalSum = temp.val + carry;
            int digit = totalSum % 10;
            carry = totalSum / 10;

            temp.val = digit;
            if (carry != 0) {
                Node newNode = new Node(carry);
                temp.next = newNode;
            }
        }

        // reverse
        head = reverseLL(head);

        return head;
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
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);

        Node head = node1;
        node1.next = node2;
        node2.next = node3;

        printLL(head);

        printLL(addOne(head));
    }
}
