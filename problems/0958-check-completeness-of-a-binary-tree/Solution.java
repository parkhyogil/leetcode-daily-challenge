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
    public boolean isCompleteTree(TreeNode root) {
        int h = getHeight(root);
        
        LinkedList<TreeNode> level = new LinkedList<>();
        level.add(root);

        for (int i = 0; i < h - 1; i++) {
            int size = level.size();

            for (int j = 0; j < size; j++) {
                TreeNode node = level.removeFirst();
                if (node == null) {
                    return false;
                }

                level.add(node.left);
                level.add(node.right);
            }
        }

        while (level.getLast() == null) {
            level.removeLast();
        }

        for (TreeNode node : level) {
            if (node == null || node.left != null || node.right != null) {
                return false;
            }
        }

        return true;
    }

    private int getHeight(TreeNode root) {
        int res = 0;
        while (root != null) {
            root = root.left;
            res++;
        }
        return res;
    }
}
