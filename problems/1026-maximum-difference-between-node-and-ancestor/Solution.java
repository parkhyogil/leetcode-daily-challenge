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
    public int maxAncestorDiff(TreeNode root) {
        return recur(root, root.val, root.val);
    }

    private int recur(TreeNode root, int min, int max) {
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        if (root.left == null && root.right == null) {
            return max - min;
        }

        if (root.left == null) {
            return recur(root.right, min, max);
        }

        if (root.right == null) {
            return recur(root.left, min, max);
        }

        return Math.max(recur(root.left, min, max), recur(root.right, min, max));
    }
}
