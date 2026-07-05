
public class LinkedList {
    public Node head;
    public Node tail;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void deleteAtHead() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        head = head.next;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void deleteAtTail() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = head;

        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;
    }

    public int deleteAtMiddle(int position) {
        if (head == null) {
            throw new RuntimeException("Linked list is empty");
        }

        int size = size();

        if (position < 1 || position > size) {
            throw new RuntimeException("Invalid Index. Please Insert valid Index");
        }

        if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        if (position == 1) {
            int val = head.data;
            head = head.next;
            return val;
        } else if (position == size) {
            Node prev = head;
            while (prev.next != tail) {
                prev = prev.next;
            }
            int val = tail.data;
            prev.next = null;
            tail = prev;
            return val;
        } else {
            Node prev = head;
            while (position != 2) {
                prev = prev.next;
                position--;
            }

            int val = prev.next.data;

            prev.next = prev.next.next;
            return val;
        }
    }

    public int size() {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public int size(Node head) {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void printLL() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("Null");
    }

    public void printLL(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("Null");
    }

    public boolean searchByValue(int key) {
        if (head == null) {
            return false;
        }

        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }
}
