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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeOf = new HashMap<>();
        Map<TreeNode, TreeNode> parentOf = new HashMap<>();

        TreeNode root = null;
        
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];

            if (!nodeOf.containsKey(parentVal)) {
                nodeOf.put(parentVal, new TreeNode(parentVal));
            }
            if (!nodeOf.containsKey(childVal)) {
                nodeOf.put(childVal, new TreeNode(childVal));
            }

            TreeNode parent = nodeOf.get(parentVal);
            TreeNode child = nodeOf.get(childVal);

            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            parentOf.put(child, parent);

            root = parent;
        }

        while (parentOf.containsKey(root)) {
            root = parentOf.get(root);
        }

        return root;
    }
}
