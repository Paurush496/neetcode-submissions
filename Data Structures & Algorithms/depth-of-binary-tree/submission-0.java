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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int maxRightDepth = 1, maxLeftDepth = 1;

        if (root.right != null) {
            maxRightDepth += maxDepth(root.right);
        }
        if (root.left != null) {
            maxLeftDepth += maxDepth(root.left);
        }
        return Math.max(maxRightDepth, maxLeftDepth);
    }
}
