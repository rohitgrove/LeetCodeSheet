import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void printLists(ListNode[] lists) {
        for (ListNode head : lists) {
            printList(head);
        }
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Compare());

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode head = null;
        ListNode tail = null;

        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            if (head == null) {
                head = top;
                tail = top;
                if (tail.next != null) {
                    pq.offer(tail.next);
                }
            } else {
                tail.next = top;
                tail = top;
                if (tail.next != null) {
                    pq.offer(tail.next);
                }
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode lists[] = new ListNode[3];
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);
        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;
        printLists(lists);
        printList(mergeKLists(lists));
    }
}
