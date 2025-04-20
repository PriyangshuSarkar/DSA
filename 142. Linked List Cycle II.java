
class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Cycle detected
                System.out.println("Cycle detected at node: " + slow.val);

                // Find cycle start
                slow = head;
                while (slow != fast) {
                    System.out.println("Slow at: " + slow.val + ", Fast at: " + fast.val);
                    slow = slow.next;
                    fast = fast.next;
                }

                System.out.println("Cycle starts at node: " + slow.val);
                return slow;
            }
        }

        System.out.println("No cycle detected.");
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating a linked list with a cycle
        ListNode head = solution.new ListNode(3);
        ListNode node1 = solution.new ListNode(2);
        ListNode node2 = solution.new ListNode(0);
        ListNode node3 = solution.new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // Creating a cycle (pointing to node1)

        // Detect cycle
        ListNode cycleStart = solution.detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle detected at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle found.");
        }
    }
}