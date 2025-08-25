public class Sort012 {
    public static Node segregateHelper1(Node head) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.val == 0) {
                zeroCount++;
            } else if (temp.val == 1) {
                oneCount++;
            } else if (temp.val == 2) {
                twoCount++;
            }
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (zeroCount != 0) {
                temp.val = 0;
                zeroCount--;
            } else if (oneCount != 0) {
                temp.val = 1;
                oneCount--;
            } else if (twoCount != 0) {
                temp.val = 2;
                twoCount--;
            }

            temp = temp.next;
        }

        return head;
    }

    public static Node segregateHelper2(Node head) {
        if (head == null || head.next == null)
            return head;

        // Dummy heads
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        // Tails
        Node zero = zeroHead, one = oneHead, two = twoHead;

        // Traverse
        Node curr = head;
        while (curr != null) {
            if (curr.val == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.val == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        // Connect lists: zero -> one -> two
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }

    public static Node segregate(Node head) {
        return segregateHelper1(head);
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

        printLL(head);
        printLL(segregate(head));
    }
}
