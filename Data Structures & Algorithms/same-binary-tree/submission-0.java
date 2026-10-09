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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> bfsP = new LinkedList<>();
        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsP.offer(p);
        bfsQ.offer(q);
        while (!bfsP.isEmpty() && !bfsQ.isEmpty()) {
            int len = bfsP.size();
            for (int i = 0; i < len; i++) {
                TreeNode nodeP = bfsP.poll();
                TreeNode nodeQ = bfsQ.poll();
                if (nodeP == null && nodeQ == null)
                    continue;
                else if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val)
                    return false;
                if (nodeP != null) {
                    bfsP.offer(nodeP.left);
                    bfsP.offer(nodeP.right);
                }
                if (nodeQ != null) {
                    bfsQ.offer(nodeQ.left);
                    bfsQ.offer(nodeQ.right);
                }
            }
            if (bfsP.size() != bfsQ.size())
                return false;
        }
        return true;
    }
}
