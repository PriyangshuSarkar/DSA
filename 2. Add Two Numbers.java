/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null)
            return null;

        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode l3 = new ListNode();
        ListNode h3 = l3;
        int carry = 0;

        while (h1 != null || h2 != null || carry > 0) {
            int sum = (h1 != null ? h1.val : 0) + (h2 != null ? h2.val : 0) + carry;
            carry = sum / 10;

            h3.next = new ListNode(sum % 10);
            h3 = h3.next;

            if (h1 != null)
                h1 = h1.next;
            if (h2 != null)
                h2 = h2.next;
        }

        return l3.next;

    }

    @SuppressWarnings("unused")
    public class ListNode {
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

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating first number: 342 -> [2 -> 4 -> 3]
        Solution.ListNode l1 = solution.new ListNode(2, solution.new ListNode(4, solution.new ListNode(3)));

        // Creating second number: 465 -> [5 -> 6 -> 4]
        Solution.ListNode l2 = solution.new ListNode(5, solution.new ListNode(6));

        // Calling the method
        Solution.ListNode result = solution.addTwoNumbers(l1, l2);

        // Printing the result
        printList(result);
    }

    // Utility function to print a linked list
    private static void printList(Solution.ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null)
                System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
}