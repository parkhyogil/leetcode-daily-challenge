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
    private int pIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        pIdx = n - 1;

        Map<Integer, Integer> idxOf = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxOf.put(inorder[i], i);
        }

        return build(postorder, 0, n - 1, idxOf);
    }

    private TreeNode build(int[] postorder, int s, int e, Map<Integer, Integer> idxOf) {
        if (s > e) {
            return null;
        }
        int val = postorder[pIdx--];
        int idx = idxOf.get(val);

        TreeNode root = new TreeNode(val);
        root.right = build(postorder, idx + 1, e, idxOf);
        root.left = build(postorder, s, idx - 1, idxOf);
        return root;
    }
}
