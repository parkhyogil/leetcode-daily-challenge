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
class FindElements {
    private TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;    
    }
    
    public boolean find(int target) {
        return findNode(target + 1) != null;
    }

    private TreeNode findNode(int target) {
        if (target == 1) {
            return root;
        }

        TreeNode parentNode = findNode(target / 2);
        if (parentNode == null) {
            return null;
        }
        
        return target % 2 == 0 ? parentNode.left : parentNode.right;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
