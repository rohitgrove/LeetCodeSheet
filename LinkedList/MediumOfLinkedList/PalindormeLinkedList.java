public class PalindormeLinkedList {
    public static Node getMiddleElement(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node getMiddle = getMiddleElement(head);

        Node head2 = getMiddle.next;

        getMiddle.next = null;
        
        head2 = reverseLL(head2);

        while (head != null && head2 != null) {
            if (head.data != head2.data) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        LinkedList.printLL(head);
        System.out.println(isPalindrome(head));
    }
}
