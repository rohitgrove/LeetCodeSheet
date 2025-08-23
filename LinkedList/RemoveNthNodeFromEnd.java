public class RemoveNthNodeFromEnd {
    public static int size(Node head) {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }

    public static Node method1(Node head, int n) {
        int size = size(head);

        Node curr = head;
        Node prev = null;

        int pos = size - n;

        if (pos == 0) {
            return head.next;
        }

        while (pos-- > 0) {
            prev = curr;
            curr = curr.next;
        }

        if (prev != null) {
            prev.next = curr.next;
        }

        return head;
    }

    public static Node method2(Node head, int n) {
        int size = size(head);

        Node curr = head;

        int pos = size - n;

        if (pos == 0) {
            return head.next;
        }

        while (pos-- > 1) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }

    public static Node removeNthFromEnd(Node head, int n) {
        return method2(head, n);
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
        head = removeNthFromEnd(head, 2);
        printLL(head);
    }
}
