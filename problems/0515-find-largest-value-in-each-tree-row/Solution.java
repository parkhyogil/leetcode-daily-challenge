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
        List<Integer> res = new ArrayList<>();

        dfs(0, root, res);

        return res;
    }

    private void dfs(int depth, TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (res.size() == depth) {
            res.add(node.val);
        } else {
            res.set(depth, Math.max(res.get(depth), node.val));
        }

        dfs(depth + 1, node.left, res);
        dfs(depth + 1, node.right, res);
    }
}
