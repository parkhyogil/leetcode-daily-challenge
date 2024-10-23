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
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> levelSums = new ArrayList<>();

        preorderTraversal(0, root, levelSums);

        replaceChildValue(0, 0, root, levelSums);

        return root;
    }

    void replaceChildValue(int level, int siblingVal, TreeNode root, List<Integer> levelSums) {
        if (root == null) {
            return;
        }

        int leftChildVal = root.left == null ? 0 : root.left.val;
        int rightChildVal = root.right == null ? 0 : root.right.val;

        root.val = levelSums.get(level) - root.val - siblingVal;

        replaceChildValue(level + 1, rightChildVal, root.left, levelSums);
        replaceChildValue(level + 1, leftChildVal, root.right, levelSums);
    }

    void preorderTraversal(int level, TreeNode root, List<Integer> levelSums) {
        if (root == null) {
            return;
        }
        
        if (levelSums.size() == level) {
            levelSums.add(root.val);
        } else {
            levelSums.set(level, levelSums.get(level) + root.val);
        }

        preorderTraversal(level + 1, root.left, levelSums);
        preorderTraversal(level + 1, root.right, levelSums);
    }
}
