public class SortLL {
    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node list1 = head;
        Node list2 = mid.next;
        mid.next = null;

        list1 = sortList(list1);
        list2 = sortList(list2);

        return merge(list1, list2);
    }

    public static Node merge(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        Node ans = new Node(-1);
        Node mtr = ans;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                mtr.next = list1;
                mtr = list1;
                list1 = list1.next;
            } else {
                mtr.next = list2;
                mtr = list2;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            mtr.next = list1;
        }

        if (list2 != null) {
            mtr.next = list2;
        }

        return ans.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        Node node4 = new Node(3);

        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        LinkedList.printLL(head);
        LinkedList.printLL(sortList(head));
    }
}
