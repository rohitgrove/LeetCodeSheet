public class ReverseALinkedList {
    public static Node reverseListUsingItr(Node head) {
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

    public static Node reverseListUsingRec(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }

        Node next = curr.next;
        curr.next = prev;
        
        return reverseListUsingRec(curr, next);
    }

    public static Node reverseList(Node head) {
        return reverseListUsingRec(null, head);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        LinkedList.printLL(head);
        LinkedList.printLL(reverseList(head));
    }
}
