public class PalindormeLL {
    public static Node getMidNode(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node reverseNode(Node head) {
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
        Node midNode = getMidNode(head);
        Node head2 = midNode.next;
        midNode.next = null;
        head2 = reverseNode(head2);

        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                return false;
            }

            head = head.next;
            head2 = head2.next;
        }

        return true;
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

        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        printLL(head);
        System.out.println(isPalindrome(head));
    }
}
