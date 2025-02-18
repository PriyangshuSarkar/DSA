
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating two sample binary trees
        Solution.TreeNode tree1 = solution.new TreeNode(1);
        tree1.left = solution.new TreeNode(2);
        tree1.right = solution.new TreeNode(3);

        Solution.TreeNode tree2 = solution.new TreeNode(1);
        tree2.left = solution.new TreeNode(2);
        tree2.right = solution.new TreeNode(3);

        // Checking if the two trees are the same
        boolean isSame = solution.isSameTree(tree1, tree2);

        // Printing the result
        System.out.println("Are the two trees the same? " + isSame);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {

            return true;
        }

        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
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
