class Solution {
    public int longestZigZag(TreeNode root) {
        return recur(root)[2];
    }

    private int[] recur(TreeNode node) {
        if (node == null) {
            return new int[] {-1, -1, 0};
        }

        int[] left = recur(node.left);
        int[] right = recur(node.right);

        int[] res = new int[3];
        res[0] = left[1] + 1;
        res[1] = right[0] + 1;
        res[2] = Math.max(res[0], Math.max(res[1], Math.max(left[2], right[2])));
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
