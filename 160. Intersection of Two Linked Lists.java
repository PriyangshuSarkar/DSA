// import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // HashSet<ListNode> set = new HashSet<>();

        // ListNode p1 = headA;
        // ListNode p2 = headB;

        // while (p1 != null || p2 != null) {

        // if (p1 != null) {
        // if (set.contains(p1)) {
        // return p1;
        // }
        // set.add(p1);
        // p1 = p1.next;
        // }

        // if (p2 != null) {
        // if (set.contains(p2)) {
        // return p2;
        // }
        // set.add(p2);
        // p2 = p2.next;
        // }
        // }

        // return null;

        if (headA == null || headB == null)
            return null;

        ListNode p1 = headA, p2 = headB;

        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        return p1;
    }

    @SuppressWarnings("unsaved")
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        // Creating intersecting linked lists
        Solution.ListNode common = new Solution().new ListNode(8);
        common.next = new Solution().new ListNode(10);

        Solution.ListNode headA = new Solution().new ListNode(1);
        headA.next = new Solution().new ListNode(3);
        headA.next.next = common; // Intersection starts here

        Solution.ListNode headB = new Solution().new ListNode(2);
        headB.next = common; // Intersection starts here

        Solution solution = new Solution();
        Solution.ListNode intersection = solution.getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}