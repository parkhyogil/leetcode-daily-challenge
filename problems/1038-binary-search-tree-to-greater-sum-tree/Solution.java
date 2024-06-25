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
    public TreeNode bstToGst(TreeNode root) {
        recur(root, 0);

        return root;
    }

    private int recur(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }

        int rightSum = recur(root.right, sum);

        root.val += rightSum;

        int leftSum = recur(root.left, root.val);

        return leftSum;
    }
}
