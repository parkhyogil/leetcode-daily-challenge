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
    long result = 0;

    public int maxProduct(TreeNode root) {
        long totalSum = dfs(root, 0);

        dfs(root, totalSum);

        return (int) (result % 1000000007);
    }

    long dfs(TreeNode node, long totalSum) {
        if (node == null) {
            return 0;
        }

        long subSum = node.val + dfs(node.left, totalSum) + dfs(node.right, totalSum);

        result = Math.max(result, (totalSum - subSum) * subSum);

        return subSum;
    }


}
