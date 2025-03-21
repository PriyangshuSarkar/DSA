import java.util.*;

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
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while (!minHeap.isEmpty()) {

            ListNode minNode = minHeap.poll();

            head.next = minNode;

            head = minNode;

            if (minNode.next != null) {

                minHeap.add(minNode.next);
            }

        }

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

        // Creating test linked lists
        ListNode list1 = new Solution().new ListNode(1);
        list1.next = new Solution().new ListNode(10);
        list1.next.next = new Solution().new ListNode(20);

        ListNode list2 = new Solution().new ListNode(2);
        list2.next = new Solution().new ListNode(5);
        list2.next.next = new Solution().new ListNode(8);

        ListNode list3 = new Solution().new ListNode(3);
        list3.next = new Solution().new ListNode(6);
        list3.next.next = new Solution().new ListNode(9);

        ListNode[] lists = { list1, list2, list3 }; // Array of sorted linked lists

        // Merging k sorted lists
        solution.mergeKLists(lists);

        // Printing the merged sorted list
        // solution.printList(mergedList);
    }

    // Helper method to print a linked list
    // public void printList(ListNode head) {
    // ListNode dummyHead = head;
    // while (dummyHead != null) {
    // System.out.print(dummyHead.val + " -> ");
    // dummyHead = dummyHead.next;
    // }
    // System.out.println("null");
    // }

    // public void printHeapStructure(PriorityQueue<ListNode> heap) {
    // if (heap.isEmpty()) {
    // System.out.println("Heap is empty.");
    // return;
    // }

    // List<ListNode> heapList = new ArrayList<>(heap);
    // heapList.sort(Comparator.comparingInt(node -> node.val)); // Sort to show
    // heap levels correctly

    // int levels = (int) (Math.log(heapList.size()) / Math.log(2)) + 1;
    // int index = 0;

    // for (int i = 0; i < levels; i++) {
    // int nodesInLevel = (int) Math.pow(2, i);

    // // Indentation for better tree structure
    // System.out.print(" ".repeat((int) Math.pow(2, levels - i - 1)));

    // for (int j = 0; j < nodesInLevel && index < heapList.size(); j++) {
    // ListNode node = heapList.get(index);
    // System.out.print(node.val + " ");
    // index++;
    // }
    // System.out.println(); // Move to the next level
    // }

    // System.out.println("\nFull Heap Nodes with their Linked Lists:");
    // for (ListNode node : heapList) {
    // System.out.print("Node " + node.val + " -> ");
    // printList(node);
    // }
    // }
}