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

    public int countPairs(TreeNode root, int distance) {
        res = 0;

        recur(root, distance);
        
        return res;
    }

    private int[] recur(TreeNode node, int distance) {
        if (node == null) {
            return new int[distance + 1];
        }

        if (node.left == null && node.right == null) {
            int[] curr = new int[distance + 1];
            curr[1] = 1;
            return curr;
        }

        int[] left = recur(node.left, distance);
        int[] right = recur(node.right, distance);

        for (int leftDist = 1; leftDist < distance; leftDist++) {
            for (int rightDist = distance - leftDist; rightDist > 0; rightDist--) {
                res += left[leftDist] * right[rightDist];
            }
        }

        int[] curr = new int[distance + 1];
        for (int dist = 1; dist <= distance; dist++) {
            curr[dist] = left[dist - 1] + right[dist - 1];
        }   

        return curr;
    }
}
