class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                TreeNode node = q.poll();

                if (node.left == null && node.right == null) {
                    return res;
                }

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res++;
        }

        return res;
    }
}
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
