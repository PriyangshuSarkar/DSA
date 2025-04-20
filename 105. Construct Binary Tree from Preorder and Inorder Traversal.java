import java.util.HashMap;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (inorder == null || preorder == null || inorder.length != preorder.length) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, map);

    }

    public TreeNode helper(int[] inOrder, int iStart, int iEnd, int[] preorder, int pStart, int pEnd,
            HashMap<Integer, Integer> map) {

        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);

        int iRoot = map.get(root.val);

        int numsLeft = iRoot - iStart;

        root.left = helper(inOrder, iStart, iRoot - 1, preorder, pStart + 1, pStart + numsLeft, map);
        root.right = helper(inOrder, iRoot + 1, iEnd, preorder, pStart + numsLeft + 1, pEnd, map);

        return root;

    }

    @SuppressWarnings("unsaved")
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