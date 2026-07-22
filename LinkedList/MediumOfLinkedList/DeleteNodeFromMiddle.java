public class DeleteNodeFromMiddle {
    public static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node middlePrev = getMiddle(head);
        middlePrev.next = middlePrev.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(7);
        Node node5 = new Node(1);
        Node node6 = new Node(2);
        Node node7 = new Node(6);

        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        LinkedList.printLL(head);
        // System.out.println(deleteMiddle(head).data);
        LinkedList.printLL(deleteMiddle(head));

        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);
        node4 = new Node(4);
        Node head2 = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        LinkedList.printLL(head2);
        // System.out.println(deleteMiddle(head2).data);
        LinkedList.printLL(deleteMiddle(head2));
    }
}
