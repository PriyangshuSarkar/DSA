
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

import java.util.*;

class Solution {
    // HashMap<Integer, List<Integer>> map = new HashMap<>();

    // public List<List<Integer>> levelOrder(TreeNode root) {

    // dfs(root, 0);

    // List<List<Integer>> list = new ArrayList<>(map.values());

    // return list;

    // }

    // public void dfs(TreeNode root, int level) {
    // if (root == null)
    // return;

    // List<Integer> list = map.getOrDefault(level, new ArrayList<>());
    // list.add(root.val);
    // map.put(level, list);

    // dfs(root.left, level + 1);
    // dfs(root.right, level + 1);

    // return;
    // }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);

        }
        return result;
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