public class CopyListWithRandomPointer {
    public static ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curr = head;

        while (curr != null) {
            ListNode newNode = new ListNode(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;

            curr = curr.next.next;
        }

        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        ListNode newHead = head.next;
        curr = head;
        ListNode newNode = newHead;
        while (curr != null) {
            curr.next = newNode.next;
            if (newNode.next != null) {
                newNode.next = newNode.next.next;
                newNode = newNode.next;
            }
            curr = curr.next;
        }

        return newHead;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.random != null) {
                System.out.print("{" + temp.val + ", " + temp.random.val + "} ");
            } else {
                System.out.print("{" + temp.val + ", " + "null }");
            }

            temp = temp.next;
        }

        System.out.println("Null");
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(13);
        ListNode node3 = new ListNode(11);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(1);

        ListNode head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        printList(head);
        printList(copyRandomList(head));
    }
}
