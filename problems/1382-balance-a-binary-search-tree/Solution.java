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

        return build(0, nodes.size() - 1, nodes);
    }

    TreeNode build(int l, int r, List<TreeNode> nodes) {
        if (l > r) {
            return null;
        }

        int m = (l + r) / 2;

        TreeNode root = nodes.get(m);

        root.left = build(l, m - 1, nodes);
        root.right = build(m + 1, r, nodes);

        return root;
    }

    void inorder(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        
        inorder(node.left, nodes);
        nodes.add(node);
        inorder(node.right, nodes);

        node.left = null;
        node.right = null;
    }
}
