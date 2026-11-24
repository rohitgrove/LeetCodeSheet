import java.util.HashMap;

public class LinkedListCycle {
    public static boolean slowFastApproach(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static boolean mapApproach(Node head) {
        HashMap<Node, Boolean> table = new HashMap<>();

        Node temp = head;
        while (temp != null) {
            if (table.containsKey(temp)) {
                return true;
            }
            table.put(temp, true);
            temp = temp.next;
        }

        return false;
    }

    public static boolean hasCycle(Node head) {
        return slowFastApproach(head);
    }

    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(0);
        Node node4 = new Node(-4);

        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(hasCycle(head));
    }
}
