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
    private int res;

    public int distributeCoins(TreeNode root) {
        res = 0;

        recur(root);

        return res;
    }

    private int[] recur(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }

        int[] left = recur(root.left);
        int[] right = recur(root.right);

        int need = left[0] + right[0] + 1;
        int have = left[1] + right[1] + root.val;

        if (need > have) {
            need -= have;
            have = 0;
        } else {
            have -= need;
            need = 0;
        }

        res += need + have;

        return new int[] {need, have};
    }
}
