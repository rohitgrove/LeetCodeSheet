public class RemoveNthNodeFromList {
    public static int size(Node head) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public static Node removeNthFromEnd(Node head, int n) {
        int len = size(head);
        if (n > len) {
            return head;
        }

        if (n == len) {
            return head.next;
        }

        Node temp = head;

        len = len - 1;

        while (len != n) {
            temp = temp.next;
            len--;
        }

        temp.next = temp.next.next;

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
        LinkedList.printLL(removeNthFromEnd(head, 2));
    }
}
