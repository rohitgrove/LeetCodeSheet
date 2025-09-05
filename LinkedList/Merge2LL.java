public class Merge2LL {
    public static Node mergeTwoLists(Node list1, Node list2) {
        Node ans = new Node(-1);
        Node mtpr = ans;

        while (list1 != null && list2 !=  null) {
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

        if (list2 != null) {
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
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node head1 = node1;
        node1.next = node2;
        node2.next = node3;
        printLL(head1);

        Node node4 = new Node(1);
        Node node5 = new Node(3);
        Node node6 = new Node(4);
        Node head2 = node4;
        node4.next = node5;
        node5.next = node6;
        printLL(head2);

        printLL(mergeTwoLists(head1, head2));
    }
}
