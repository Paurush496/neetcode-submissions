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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<Integer> subStruc = createSubStructure(subRoot);

        List<TreeNode> subRoots = new ArrayList<>();
        Queue<TreeNode> rootBfs = new LinkedList<>();
        rootBfs.offer(root);

        while (!rootBfs.isEmpty()) {
            TreeNode current = rootBfs.poll();
            if (current != null) {
                if (current.val == subRoot.val)
                    subRoots.add(current);
                rootBfs.offer(current.left);
                rootBfs.offer(current.right);
            }
        }

        for (TreeNode sub : subRoots) {
            List<Integer> rootSubStruc = createSubStructure(sub);
            if (rootSubStruc.equals(subStruc))
                return true;
        }
        return false;
    }

    public List<Integer> createSubStructure(TreeNode node) {
        List<Integer> subStruc = new LinkedList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(node);
        while (!bfs.isEmpty()) {
            TreeNode current = bfs.poll();
            if (current == null) {
                subStruc.add(null);
            } else {
                subStruc.add(current.val);
                bfs.offer(current.left);
                bfs.offer(current.right);
            }
        }
        return subStruc;
    }
}
