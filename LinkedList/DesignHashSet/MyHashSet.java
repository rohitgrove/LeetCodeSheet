public class MyHashSet {
    private ListNode head;
    private ListNode tail;

    public MyHashSet() {
        head = null;
        tail = null;
    }

    // add in sorted order without duplicates
    public void add(int key) {
        if (contains(key)) return; // already present

        ListNode newNode = new ListNode(key);

        // case 1: empty list
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // case 2: insert at beginning
        if (key < head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // traverse to find position
        ListNode curr = head;
        while (curr.next != null && curr.next.data < key) {
            curr = curr.next;
        }

        // insert after curr
        newNode.next = curr.next;
        curr.next = newNode;

        // update tail if inserted at end
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    // remove a key
    public void remove(int key) {
        if (head == null) return;

        // case 1: single node
        if (head == tail) {
            if (head.data == key) {
                head = tail = null;
            }
            return;
        }

        // case 2: head node delete
        if (head.data == key) {
            head = head.next;
            return;
        }

        // case 3: general case
        ListNode curr = head;
        while (curr.next != null && curr.next.data != key) {
            curr = curr.next;
        }

        if (curr.next != null) { // found
            if (curr.next == tail) {
                tail = curr; // update tail if deleting last
            }
            curr.next = curr.next.next;
        }
    }

    // check if key exists
    public boolean contains(int key) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    // print set
    public void printHashSet() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " , ");
            temp = temp.next;
        }
        System.out.println();
    }
}
