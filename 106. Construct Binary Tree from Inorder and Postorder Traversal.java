import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {

        if (inOrder == null || postOrder == null || inOrder.length != postOrder.length)
            return null;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        return helper(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1, map);

    }

    public TreeNode helper(int[] inOrder, int iStart, int iEnd, int[] postOrder, int pStart, int pEnd,
            HashMap<Integer, Integer> map) {

        if (pStart > pEnd || iStart > iEnd)
            return null;

        TreeNode root = new TreeNode(postOrder[pEnd]);

        int iRoot = map.get(postOrder[pEnd]);

        int numsLeft = iRoot - iStart;

        root.left = helper(inOrder, iStart, iRoot - 1, postOrder, pStart, pStart + numsLeft - 1, map);

        root.right = helper(inOrder, iRoot + 1, iEnd, postOrder, pStart + numsLeft, pEnd - 1, map);

        return root;
    }

    @SuppressWarnings("unused")
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}