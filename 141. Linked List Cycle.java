
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode f = head;
        ListNode l = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            l = l.next;
            if (f == l) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: No cycle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        System.out.println("Test case 1: " + solution.hasCycle(head1)); // Expected Output: false

        // Test case 2: Cycle present
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = head2.next; // Creating a cycle
        System.out.println("Test case 2: " + solution.hasCycle(head2)); // Expected Output: true

        // Test case 3: Single node, no cycle
        ListNode head3 = new ListNode(1);
        System.out.println("Test case 3: " + solution.hasCycle(head3)); // Expected Output: false

        // Test case 4: Single node with a cycle (points to itself)
        ListNode head4 = new ListNode(1);
        head4.next = head4; // Creating a cycle (node points to itself)
        System.out.println("Test case 4: " + solution.hasCycle(head4)); // Expected Output: true

        // Test case 5: Empty list
        ListNode head5 = null;
        System.out.println("Test case 5: " + solution.hasCycle(head5)); // Expected Output: false
    }
}

@SuppressWarnings("unused")
class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
