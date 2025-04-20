
class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] values1 = { 1, 2, 3, 4, 5 };
        ListNode head1 = createList(values1);
        System.out.println("Original List:");
        printList(head1);
        ListNode reversed1 = solution.reverseList(head1);
        System.out.println("Reversed List:");
        printList(reversed1);

        // Test case 2
        int[] values2 = { 1 };
        ListNode head2 = createList(values2);
        System.out.println("\nOriginal List:");
        printList(head2);
        ListNode reversed2 = solution.reverseList(head2);
        System.out.println("Reversed List:");
        printList(reversed2);

        // Test case 3
        int[] values3 = {};
        ListNode head3 = createList(values3);
        System.out.println("\nOriginal List:");
        printList(head3);
        ListNode reversed3 = solution.reverseList(head3);
        System.out.println("Reversed List:");
        printList(reversed3);
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Helper method to create a linked list from an array
    public static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(-1); // Dummy node for easier list creation
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next; // Return the actual head of the list
    }
}

@SuppressWarnings("unused")
class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
