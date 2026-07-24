public class Sort012 {
    public static Node createList(Node head, int val) {
        Node head0 = new Node(-1);
        Node curr = head0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                curr.next = new Node(val);
                curr = curr.next;
            }
            temp = temp.next;
        }

        head0 = head0.next;
        return head0;
    }

    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node head0 = createList(head, 0);
        Node head1 = createList(head, 1);
        Node head2 = createList(head, 2);

        Node temp = head0;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head1;

        temp = head1;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head2;

        return head0;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(1);
        Node node5 = new Node(2);
        Node node6 = new Node(0);
        Node node7 = new Node(2);
        Node node8 = new Node(2);
        
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        LinkedList.printLL(head);
        LinkedList.printLL(sort(head));
    }
}
