public class IntersectionOf2LL {
    public static Node getIntersectionNode(Node headA, Node headB) {
        Node tempa = headA;
        Node tempb = headB;

        while (tempa.next != null && tempb.next != null) {
            if (tempa == tempb) {
                return tempa;
            }

            tempa = tempa.next;
            tempb = tempb.next;
        }

        if (tempa.next == null && tempb.next == null && tempa != tempb) {
            return null;
        }

        if (tempa.next == null) {
            int lenb = 0;

            while (tempb.next != null) {
                lenb++;
                tempb = tempb.next;
            }

            while (lenb-- > 0) {
                headB = headB.next;
            }
        } else {
            int lena = 0;

            while (tempa.next != null) {
                lena++;
                tempa = tempa.next;
            }

            while (lena-- > 0) {
                headA = headA.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
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
        Node node1 = new Node(4);
        Node node2 = new Node(1);
        Node node3 = new Node(8);
        Node node4 = new Node(4);

        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(1);

        Node head1 = node1;
        Node head2 = node5;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node5.next = node6;
        node6.next = node7;
        node7.next = node3;

        printLL(head1);
        printLL(head2);

        System.out.println(getIntersectionNode(head1, head2).val);
    }
}
