public class ReverseLLInKGroups {
    public static int length(Node head) {
        Node temp = head;
        int len = 0;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        return len;
    }

    public static Node reverseKGroup(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node nextNode = curr.next;
        int pos = 0;
        int len = length(head);

        if (len < k) {
            return head;
        }

        while (pos < k) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            pos++;
        }

        if (nextNode != null) {
            Node recursionAns = reverseKGroup(nextNode, k);
            head.next = recursionAns;
        }

        return prev;
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
        printLL(reverseKGroup(head, 2));
    }
}
