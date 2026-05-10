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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr == null) {
                sb.append("# ");
            } else {
                sb.append(curr.val + " ");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") {
            return null;
        }
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for(int i = 1; i < values.length; i++) {
            TreeNode curr = queue.poll();

            if(!values[i].equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                curr.left = leftNode;
                queue.add(leftNode);
            }


            if(!values[++i].equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                curr.right = rightNode;
                queue.add(rightNode);
            }
        }

        return root;
    }
}
