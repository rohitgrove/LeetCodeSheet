public class OddEvenLL {
    public static Node method1(Node head) {
        Node odd = new Node(-1);
        Node temp = head;

        Node oddTemp = odd;
        int idx = 1;
        while (temp != null) {
            if ((idx & 1) == 1) {
                Node newNode = new Node(temp.val);
                oddTemp.next = newNode;
                oddTemp = oddTemp.next;
            }
            temp = temp.next;
            idx++;
        }

        idx = 1;
        Node even = new Node(-1);
        Node evenTemp = even;
        temp = head;
        while (temp != null) {
            if ((idx & 1) == 0) {
                Node newNode = new Node(temp.val);
                evenTemp.next = newNode;
                evenTemp = evenTemp.next;
            }
            temp = temp.next;
            idx++;
        }

        oddTemp.next = even.next;

        return odd.next;
    }

    public static Node method2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node head1 = head;
        Node head2 = head.next;

        Node temp1 = head1;
        Node temp2 = head2;

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

    public static Node oddEvenList(Node head) {
        return method2(head);
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
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        printLL(head);
        printLL(oddEvenList(head));
    }
}
