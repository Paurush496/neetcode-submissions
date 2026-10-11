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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.offer(root);
        while (!bfsQ.isEmpty()) {
            int qSize = bfsQ.size();
            List<Integer> levelVals = new ArrayList<>();
            for (int i = qSize; i > 0; i--) {
                TreeNode next = bfsQ.poll();
                levelVals.add(next.val);
                if (next.left != null)
                    bfsQ.offer(next.left);
                if (next.right != null)
                    bfsQ.offer(next.right);
            }
            result.add(levelVals);
        }
        return result;
    }
}
