public class RemoveDuplicatesFromSortedList {
    public static Node deleteDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;

        while (temp != null) {
            if (temp.next != null) {
                Node temp2 = temp;
                while (temp2.next != null && temp2.val == temp2.next.val) {
                    temp2 = temp2.next;
                }

                temp.next = temp2.next;
            }

            temp = temp.next;
        }

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
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(3);
        Node node6 = new Node(3);

        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        printLL(head);
        printLL(deleteDuplicates(head));
    }
}
