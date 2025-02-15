
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            result.next = new ListNode(sum);
            result = result.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        ListNode result = solution.addTwoNumbers(l1_1, l2_1);
        printList(result);
        // Expected Output: 7 -> 0 -> 8 (342 + 465 = 807)

        // Test case 2
        ListNode l1_2a = new ListNode(0);
        ListNode l2_2a = new ListNode(0);
        result = solution.addTwoNumbers(l1_2a, l2_2a);
        printList(result);
        // Expected Output: 0

        // Test case 3
        ListNode l1_3a = new ListNode(9);
        ListNode l1_3b = new ListNode(9);
        ListNode l1_3c = new ListNode(9);
        ListNode l1_3d = new ListNode(9);
        ListNode l1_3e = new ListNode(9);
        l1_3a.next = l1_3b;
        l1_3b.next = l1_3c;
        l1_3c.next = l1_3d;
        l1_3d.next = l1_3e;

        ListNode l2_3a = new ListNode(1);
        result = solution.addTwoNumbers(l1_3a, l2_3a);
        printList(result);
        // Expected Output: 0 -> 0 -> 0 -> 0 -> 0 -> 1 (99999 + 1 = 100000)
    }

    // Helper function to print the list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            if (node.next != null) {
                System.out.print("-> ");
            }
            node = node.next;
        }
        System.out.println();
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
