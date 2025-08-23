public class DeleteMiddleOfLL {
    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node deleteMiddleHelper1(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node mid = getMid(head);

        Node curr = head;
        while (curr.next != mid) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }

    public static Node deleteMiddleHelper2(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static Node deleteMiddle(Node head) {
        return deleteMiddleHelper2(head);
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
        printLL(head);

        printLL(deleteMiddle(head));
    }
}
