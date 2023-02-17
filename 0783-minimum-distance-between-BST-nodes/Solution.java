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
    public int minDiffInBST(TreeNode root) {
        return recur(root)[0];
    }

    private int[] recur(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        int[] left = recur(root.left);
        int[] right = recur(root.right);

        int res = Integer.MAX_VALUE;
        int min = root.val;
        int max = root.val;

        if (left != null) {
            res = Math.min(res, Math.min(left[0], root.val - left[2]));
            min = Math.min(min, left[1]);
        }
        if (right != null) {
            res = Math.min(res, Math.min(right[0], right[1] - root.val));
            max = Math.max(max, right[2]);
        }
        return new int[] {res, min, max};
    }
}
