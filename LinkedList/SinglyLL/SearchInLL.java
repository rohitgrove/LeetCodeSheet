public class SearchInLL {
    public static boolean searchKey(Node head, int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(5);
        ll1.insertAtHead(4);
        ll1.insertAtHead(3);
        ll1.insertAtHead(2);
        ll1.insertAtHead(1);
        ll1.printLL();
        System.out.println(searchKey(ll1.head, 3));
        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(9);
        ll2.insertAtHead(2);
        ll2.insertAtHead(5);
        ll2.insertAtHead(1);
        ll2.printLL();
        System.out.println(searchKey(ll2.head, 4));
    }
}
