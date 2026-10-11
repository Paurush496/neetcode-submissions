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
    int visits = 0;
    public int kthSmallest(TreeNode root, int k) {
        int result = root.val;
        if (root.left != null)
            result = kthSmallest(root.left, k);
        visits++;
        if (visits > k)
            return result;
        else if (visits == k)
            return root.val;
        if (root.right != null)
            result = kthSmallest(root.right, k);
        return result;
    }
}
