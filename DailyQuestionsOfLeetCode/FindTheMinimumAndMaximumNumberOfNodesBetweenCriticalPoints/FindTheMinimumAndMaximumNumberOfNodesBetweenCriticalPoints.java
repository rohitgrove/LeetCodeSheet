public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int last = -1;
        int minDistance = Integer.MAX_VALUE;
        int position = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null && curr.next != null) {
            boolean isCritical = (curr.val > prev.val && curr.val > curr.next.val) ||
                    (curr.val < prev.val && curr.val < curr.next.val);

            if (isCritical) {
                if (first == -1) {
                    first = position;
                } else {
                    minDistance = Math.min(minDistance, position - last);
                }

                last = position;
            }

            prev = curr;
            curr = curr.next;
            position++;
        }

        if (first == -1 || first == last) {
            return new int[] { -1, -1 };
        }

        int maxDistance = last - first;

        return new int[] { minDistance, maxDistance };
    }

    public static void printAns(int ans[]) {
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(1);
        ll1.insertAtHead(3);
        ll1.printList();
        printAns(nodesBetweenCriticalPoints(ll1.head));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(2);
        ll2.insertAtHead(1);
        ll2.insertAtHead(5);
        ll2.insertAtHead(2);
        ll2.insertAtHead(1);
        ll2.insertAtHead(3);
        ll2.insertAtHead(5);
        ll2.printList();
        printAns(nodesBetweenCriticalPoints(ll2.head));

        LinkedList ll3 = new LinkedList();
        ll3.insertAtHead(7);
        ll3.insertAtHead(2);
        ll3.insertAtHead(2);
        ll3.insertAtHead(2);
        ll3.insertAtHead(3);
        ll3.insertAtHead(2);
        ll3.insertAtHead(2);
        ll3.insertAtHead(3);
        ll3.insertAtHead(1);
        ll3.printList();
        printAns(nodesBetweenCriticalPoints(ll3.head));
    }
}
