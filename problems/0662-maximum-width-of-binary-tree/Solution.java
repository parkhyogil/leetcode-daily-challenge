class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return recur(root, 0, 1, new int[3001]);
    }

    private int recur(TreeNode node, int depth, int num, int[] leftMost) {
        if (node == null) {
            return 0;
        }
        if (leftMost[depth] == 0) {
            leftMost[depth] = num;
        }
        int res = num - leftMost[depth] + 1;
        depth++;
        return Math.max(res, Math.max(recur(node.left, depth, num * 2, leftMost), recur(node.right, depth, num * 2 + 1, leftMost)));
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
