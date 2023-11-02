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

    public int averageOfSubtree(TreeNode root) {
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

        left[0] += right[0] + root.val;
        left[1] += right[1] + 1;

        if (left[0] / left[1] == root.val) {
            res++;
        }
        
        return left;
    }
}
