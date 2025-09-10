public class MyHashMap {
    private ListNode head;
    private ListNode tail;

    public MyHashMap() {
        head = null;
        tail = null;
    }

    // add in sorted order without duplicates
    public void put(int key, int value) {
        if (contains(key)) {
            ListNode temp = head;
            while (temp.key != key) {
                temp = temp.next;
            }

            temp.value = value;
            return; // already present
        }

        ListNode newNode = new ListNode(key, value);

        // case 1: empty list
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // case 2: insert at beginning
        if (key < head.key) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // traverse to find position
        ListNode curr = head;
        while (curr.next != null && curr.next.key < key) {
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

    public int get(int key) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return -1;
    }

    // remove a key
    public void remove(int key) {
        if (head == null) {
            return;
        }

        // case 1: single node
        if (head == tail) {
            if (head.key == key) {
                head = tail = null;
            }
            return;
        }

        // case 2: head node delete
        if (head.key == key) {
            head = head.next;
            return;
        }

        // case 3: general case
        ListNode curr = head;
        while (curr.next != null && curr.next.key != key) {
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
    private boolean contains(int key) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.key == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // print set
    public void printHashMap() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print("{"+temp.key + "="+temp.value+"}");
            temp = temp.next;
        }
        System.out.println();
    }
}
