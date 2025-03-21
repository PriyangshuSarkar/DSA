
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Codec {
    public static void main(String[] args) {
        Codec codec = new Codec();
        // Construct a sample tree:
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize the tree
        String serialized = codec.serialize(root);
        System.out.println("Serialized Tree: " + serialized);

        // Deserialize back to tree
        TreeNode deserializedRoot = codec.deserialize(serialized);

        // Print tree structure to verify correctness
        System.out.println("Deserialized Tree Root Value: " + deserializedRoot.val);
        System.out.println("Left Child Value: " + (deserializedRoot.left != null ? deserializedRoot.left.val : "null"));
        System.out.println(
                "Right Child Value: " + (deserializedRoot.right != null ? deserializedRoot.right.val : "null"));
        System.out.println("Right->Left Child Value: "
                + (deserializedRoot.right.left != null ? deserializedRoot.right.left.val : "null"));
        System.out.println("Right->Right Child Value: "
                + (deserializedRoot.right.right != null ? deserializedRoot.right.right.val : "null"));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("").append("\uE000");
            return;
        }
        sb.append(node.val).append("\uE000");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] segments = data.split("\uE000");
        int index[] = { 0 };
        return deserializeHelper(segments, index);
    }

    private TreeNode deserializeHelper(String[] values, int[] index) {

        if (index[0] >= values.length || values[index[0]].equals("")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;
        node.left = deserializeHelper(values, index);
        node.right = deserializeHelper(values, index);
        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));