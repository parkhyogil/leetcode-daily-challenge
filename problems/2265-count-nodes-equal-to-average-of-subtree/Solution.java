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
    int result = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;    
    }

    int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] res = new int[] {node.val + left[0] + right[0], 1 + left[1] + right[1]};

        if (node.val == res[0] / res[1]) {
            result++;
        }

        return res;
    }
}
