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
class Result {
    int val;
    Result() {
        this.val = Integer.MIN_VALUE;
    }
}
class Solution { 
    public int maxPathSum(TreeNode root) {
        Result res = new Result();
        helper(root, res);
        return res.val;
    }

    private int helper(TreeNode node, Result res) {
        if(node == null) {
            return 0;
        }

        int leftMax = Math.max(0, helper(node.left, res));
        int rightMax = Math.max(0, helper(node.right, res));
        res.val = Math.max(res.val, leftMax + rightMax + node.val);

        return node.val + Math.max(leftMax, rightMax);
    }
}
