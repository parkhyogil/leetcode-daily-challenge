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
    public int pseudoPalindromicPaths (TreeNode root) {
        return recur(root, 0);
    }

    private int recur(TreeNode root, int bit) {
        if (root == null) {
            return 0;
        }

        bit ^= 1 << root.val;

        if (root.left == null && root.right == null) {
            return Integer.bitCount(bit) <= 1 ? 1 : 0;
        }

        return recur(root.left, bit) + recur(root.right, bit);
    }
}
