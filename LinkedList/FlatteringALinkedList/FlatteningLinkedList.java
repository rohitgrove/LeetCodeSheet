public class FlatteningLinkedList {
    public static ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        ListNode ans;
        if (a.val < b.val) {
            ans = a;
            ans.bottom = merge(a.bottom, b);
        } else {
            ans = b;
            ans.bottom = merge(a, b.bottom);
        }

        return ans;
    }

    public static ListNode mergeTwoLists(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        ListNode ans = new ListNode(-1); // Dummy node to simplify merging
        ListNode mptr = ans;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                mptr.bottom = left;
                mptr = left;
                left = left.bottom; // Use bottom instead of next
            } else {
                mptr.bottom = right;
                mptr = right;
                right = right.bottom; // Use bottom instead of next
            }
        }

        if (left != null) {
            mptr.bottom = left;
        }

        if (right != null) {
            mptr.bottom = right;
        }

        return ans.bottom;
    }

    static ListNode flatten(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        // both are correct method
        // Merge this list with the list on the right
        root = merge(root, flatten(root.next));
        // root = mergeTwoLists(root, flatten(root.next));

        return root;
    }

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(10);
        ListNode node3 = new ListNode(19);
        ListNode node4 = new ListNode(28);

        ListNode head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1.bottom = new ListNode(7);
        node1.bottom.bottom = new ListNode(8);

        node2.bottom = new ListNode(20);

        node3.bottom = new ListNode(22);

        node4.bottom = new ListNode(40);
        node4.bottom.bottom = new ListNode(45);

        printLL(flatten(head));
    }
}