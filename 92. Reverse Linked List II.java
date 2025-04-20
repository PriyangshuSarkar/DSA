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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null && left == right) {
            return null;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head;
        ListNode leftBreak = dummy;

        for (int i = 1; i < left; i++) {
            leftBreak = curr;
            curr = curr.next;
        }

        ListNode rightBreak = curr;

        ListNode prev = null;

        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        leftBreak.next = prev;
        rightBreak.next = curr;

        return dummy.next;
    }

    @SuppressWarnings("unsaved")
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

        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);
        head.next.next.next.next.next = solution.new ListNode(6);
        int left = 2;
        int right = 4;

        ListNode result = solution.reverseBetween(head, left, right);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}