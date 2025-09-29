
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
  private int count = 0;
  private int result = -1;

  public int kthSmallest(TreeNode root, int k) {

    inorder(root, k);

    return result;
  }

  public void inorder(TreeNode root, int k) {
    if (root == null)
      return;

    inorder(root.left, k);

    count++;

    if (count == k) {
      result = root.val;
      return;
    }

    inorder(root.right, k);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(1);

    int k = 3;

    System.out.println(solution.kthSmallest(root, k));
  }
}

class TreeNode {
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
