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
        Map<Integer, Integer> parentMap = new HashMap<>();
        Map<Integer, TreeNode> nodeMap = new HashMap<>();

        int any = -1;

        for (int[] d : descriptions) {
            int p = d[0], c = d[1], l = d[2];

            TreeNode parent = nodeMap.computeIfAbsent(p, k -> new TreeNode(k));
            TreeNode child = nodeMap.computeIfAbsent(c, k -> new TreeNode(k));

            if (l == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            parentMap.put(c, p);
            any = p;
        }

        while (parentMap.containsKey(any)) {
            any = parentMap.get(any);
        }

        return nodeMap.get(any);
    }
}
