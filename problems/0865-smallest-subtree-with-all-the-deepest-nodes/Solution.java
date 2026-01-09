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
    int max;
    TreeNode result;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(1, root);

        return result;    
    }

    int dfs(int d, TreeNode node) {
        if (node == null) {
            return d;
        }

        int left = dfs(d + 1, node.left);
        int right = dfs(d + 1, node.right);

        if (left == right && left >= max) {
            max = left;
            result = node;
        }   

        return Math.max(left, right);
    }
}
