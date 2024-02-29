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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = -1;

            while (size-- > 0) {
                TreeNode node = queue.poll();

                if (depth % 2 == 0) {
                    if (node.val % 2 == 0 || (prev != -1 && prev >= node.val)) {
                        return false;
                    }
                } else {
                    if (node.val % 2 == 1 || (prev != -1 && prev <= node.val)) {
                        return false;
                    }
                }

                prev = node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            depth++;
        }

        return true;
    }
}
