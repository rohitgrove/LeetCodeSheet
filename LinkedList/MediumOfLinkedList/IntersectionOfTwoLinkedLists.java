public class IntersectionOfTwoLinkedLists {
    public static Node getIntersectionNode(Node headA, Node headB) {
        Node a = headA;
        Node b = headB;

        while (a.next != null && b.next != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }

        if (a.next == null && b.next == null && a != b) {
            return null;
        }

        if (a.next == null) {
            // B linkedlist is bigger ya equal hai.
            // we need to find out how much bigger
            int blen = size(b);
            
            while (blen-- > 0) {
                headB = headB.next;
            }
        } else {
            // A linkedlist is bigger hai.
            // we need to find out how much bigger

            int alen = size(a);

            while (alen-- > 0) {
                headA = headA.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public static int size(Node head) {
        Node temp = head;
        int size = 0;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(1);
        Node seventh = new Node(2);
        Node eigth = new Node(3);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        sixth.next = seventh;
        seventh.next = eigth;
        eigth.next = third;
        Node headA = first;
        Node headB = sixth;
        System.out.println(getIntersectionNode(headA, headB).data);

        Node head1 = new Node(4);
        head1.next = new Node(1);
        head1.next.next = new Node(8);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(1);
        head2.next.next = head1.next.next;
        System.out.println(getIntersectionNode(head1, head2).data);
    }
}