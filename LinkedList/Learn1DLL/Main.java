public class Main {
    public static void main(String[] args) {
        // LinkedList ll = new LinkedList();
        // ll.insertAtHead(5);
        // ll.insertAtHead(4);
        // ll.insertAtHead(3);
        // ll.insertAtHead(2);
        // ll.insertAtHead(1);
        // System.out.println(ll.size());
        // ll.deleteAtHead();
        // System.out.println(ll.size());
        // ll.insertAtTail(1);
        // System.out.println(ll.size());
        // ll.deleteAtTail();
        // System.out.println(ll.size());
        // ll.printLL();
        LinkedList ll = new LinkedList();
        ll.insertAtHead(50);
        ll.insertAtHead(40);
        ll.insertAtHead(30);
        ll.insertAtHead(20);
        ll.insertAtHead(10);
        System.out.println(ll.searchByValue(45));
    }
}
