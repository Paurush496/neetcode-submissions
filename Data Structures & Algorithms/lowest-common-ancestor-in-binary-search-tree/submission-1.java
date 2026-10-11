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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (current != null) {
            int currentVal = current.val;
            if (p.val < currentVal && q.val > currentVal
                || (p.val > currentVal && q.val < currentVal) || p.val == currentVal
                || q.val == currentVal)
                return current;
            if (p.val < currentVal && q.val < currentVal)
                current = current.left;
            else
                current = current.right;
        }
        return root;
    }
}
