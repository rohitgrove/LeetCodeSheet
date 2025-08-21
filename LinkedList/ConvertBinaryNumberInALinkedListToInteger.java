public class ConvertBinaryNumberInALinkedListToInteger {
    public static int method1(Node head) { // tc: O(n), sc: O(n)
        StringBuilder num = new StringBuilder();

        Node temp = head;
        while (temp != null) {
            num.append(temp.val);
            temp = temp.next;
        }

        int ans = Integer.parseInt(num.toString(), 2);
        return ans;
    }

    public static int method2(Node head) { // tc: O(n), sc: O(1)
        int decimal = 0;
        Node temp = head;
        while (temp != null) {
            decimal = decimal * 2 + temp.val;
            temp = temp.next;
        }
        return decimal;
    }

    public static int getDecimalValue(Node head) {
        return method2(head);
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
        Node node2 = new Node(0);
        Node node3 = new Node(1);
        Node node4 = new Node(1);

        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        printLL(head);
        System.out.println("Decimal Number: " + getDecimalValue(head));
    }
}
