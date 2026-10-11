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
    ArrayDeque<Integer> vals = new ArrayDeque<>();

    public boolean isValidBST(TreeNode root) {
        boolean result = true;
        if (root.left != null)
            result = isValidBST(root.left);
        if (!result || (!vals.isEmpty() && vals.peekFirst() >= root.val))
            return false;
        vals.push(root.val);
        if (root.right != null)
            result = isValidBST(root.right);
        return result;
    }
}
