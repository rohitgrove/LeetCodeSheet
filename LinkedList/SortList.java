public class SortList {
    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
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

        return mergeList(list1, list2);
    }

    public static Node mergeList(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        Node ans = new Node(-1);
        Node mtpr = ans;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                mtpr.next = list1;
                mtpr = list1;
                list1 = list1.next;
            } else {
                mtpr.next = list2;
                mtpr = list2;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            mtpr.next = list1;
        }

        if  (list2 != null) {
            mtpr.next = list2;
        }

        return ans.next;
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
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        Node node4 = new Node(3);

        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("Before Sort List: ");
        printLL(head);
        System.out.println("After Sort List: ");
        printLL(sortList(head));
    }
}
