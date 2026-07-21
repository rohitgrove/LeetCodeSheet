public class OddEvenLinkedList {
    public static Node oddEvenList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp1 = head;
        Node temp2 = head.next;
        Node head1 = temp1;
        Node head2 = temp2;

        while (temp1 != null && temp2 != null) {
            temp1.next = temp2.next;
            temp1 = temp1.next;
            if (temp1 != null) {
                temp2.next = temp1.next;
                temp2 = temp2.next;
            }
        }

        temp1 = head1;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        temp1.next = head2;

        return head;
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

        LinkedList.printLL(head);
        LinkedList.printLL(oddEvenList(head));
    }
}
