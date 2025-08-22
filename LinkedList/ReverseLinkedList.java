public class ReverseLinkedList {
    public static Node reverseUsingRec(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }

        Node next = curr.next;
        curr.next = prev;

        return reverseUsingRec(curr, next);
    }

    public static Node reverseUsingItr(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        return reverseUsingRec(prev, curr);
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
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printLL(head);
        printLL(reverseList(head));
    }
}
