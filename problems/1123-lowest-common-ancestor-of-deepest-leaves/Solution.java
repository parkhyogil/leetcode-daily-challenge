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
    private int maxDepth;
    private List<TreeNode> deepestLeaves;
    private Map<Integer, TreeNode> parentMap;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxDepth = -1;
        deepestLeaves = new ArrayList<>();
        parentMap = new HashMap<>();

        traverse(0, root, null);

        TreeNode left = deepestLeaves.get(0);
        TreeNode right = deepestLeaves.get(deepestLeaves.size() - 1);

        while (left.val != right.val) {
            left = parentMap.get(left.val);
            right = parentMap.get(right.val);
        }

        return left;
    }

    private void traverse(int depth, TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }

        if (depth > maxDepth) {
            maxDepth = depth;
            deepestLeaves.clear();
            deepestLeaves.add(node);
        } else if (depth == maxDepth) {
            deepestLeaves.add(node);
        }

        parentMap.put(node.val, parent);
        traverse(depth + 1, node.left, node);
        traverse(depth + 1, node.right, node);
    }
}
