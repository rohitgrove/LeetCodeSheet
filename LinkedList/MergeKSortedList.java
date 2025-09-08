import java.util.Comparator;
import java.util.PriorityQueue;

class Compare implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.val - o2.val;
    }
}

public class MergeKSortedList {
    public static Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());

        for (Node head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        Node head = null;
        Node tail = null;

        while (!pq.isEmpty()) {
            Node topNode = pq.poll();
            if (head == null) {
                head = topNode;
                tail = topNode;
                if (tail.next != null) {
                    pq.offer(tail.next);
                }
            } else {
                tail.next = topNode;
                tail = topNode;
                if (tail.next != null) {
                    pq.offer(tail.next);
                }
            }
        }

        return head;
    }

    public static void printLists(Node lists[]) {
        for (Node head : lists) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.println("Null");
        }
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
        Node[] lists = new Node[3];
        Node head1 = new Node(1);
        head1.next = new Node(4);
        head1.next.next = new Node(5);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        Node head3 = new Node(2);
        head3.next = new Node(6);

        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;
        printLists(lists);
        printLL(mergeKLists(lists));
    }
}
