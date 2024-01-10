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

    public int amountOfTime(TreeNode root, int start) {
        res = 0;

        recur(root, start);

        return res;
    }



    private int recur(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }

        int left = recur(root.left, start);
        int right = recur(root.right, start);

        if (root.val == start) {
            res = Math.max(left, right);
            return -1;
        }            

        if (left >= 0 && right >= 0) {
            return Math.max(left, right) + 1;
        }

        res = Math.max(res, Math.abs(left) + Math.abs(right));
        return Math.min(left, right) - 1;
    }
}
