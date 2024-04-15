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
    public int sumNumbers(TreeNode root) {
        return recur(root, 0);
    }

    private int recur(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return sum;
        }

        return recur(root.left, sum) + recur(root.right, sum);
    }
}
