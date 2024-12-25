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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        dfs(0, root, result);

        return result;
    }

    void dfs(int row, TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (result.size() == row) {
            result.add(node.val);
        } else if (node.val > result.get(row)) {
            result.set(row, node.val);
        }

        dfs(row + 1, node.left, result);
        dfs(row + 1, node.right, result);
    }
}
