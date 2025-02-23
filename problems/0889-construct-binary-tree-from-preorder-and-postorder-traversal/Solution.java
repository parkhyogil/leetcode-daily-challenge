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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;

        return construct(0, n - 1, preorder, 0, n - 1, postorder);
    }

    private TreeNode construct(int l0, int r0, int[] preorder, int l1, int r1, int[] postorder) {
        if (l0 > r0) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[l0]);

        if (l0 == r0) {
            return root;
        }

        l0++;
        r1--;

        int sizeLeftSubtree = 0;

        while (preorder[l0] != postorder[l1 + sizeLeftSubtree]) {
            sizeLeftSubtree++;
        }

        root.left = construct(l0, l0 + sizeLeftSubtree, preorder, l1, l1 + sizeLeftSubtree, postorder);
        root.right = construct(l0 + sizeLeftSubtree + 1, r0, preorder, l1 + sizeLeftSubtree + 1, r1, postorder);

        return root;
    }
}
