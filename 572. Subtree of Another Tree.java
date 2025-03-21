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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        if (helper(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public boolean helper(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        TreeNode root = solution.new TreeNode(3);
        root.left = solution.new TreeNode(4);
        root.right = solution.new TreeNode(5);
        root.left.left = solution.new TreeNode(1);
        root.left.right = solution.new TreeNode(2);

        TreeNode subRoot = solution.new TreeNode(4);
        subRoot.left = solution.new TreeNode(1);
        subRoot.right = solution.new TreeNode(2);

        boolean result = solution.isSubtree(root, subRoot);

        System.out.println(result);
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