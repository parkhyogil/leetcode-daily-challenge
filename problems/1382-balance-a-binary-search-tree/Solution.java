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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();

        inorder(root, nodes);

        return buildTree(0, nodes.size() - 1, nodes);
    }

    private TreeNode buildTree(int left, int right, List<TreeNode> nodes) {
        if (left > right) {
            return null;
        }

        int rootIdx = (left + right) / 2;
        TreeNode root = nodes.get(rootIdx);

        root.left = buildTree(left, rootIdx - 1, nodes);
        root.right = buildTree(rootIdx + 1, right, nodes);

        return root;
    }

    private void inorder(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }

        inorder(root.left, nodes);
        nodes.add(root);
        inorder(root.right, nodes);

        root.left = null;
        root.right = null;
    }
}
