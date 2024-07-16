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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LAC = getLCA(root, startValue, destValue);

        List<Character> startPath = new ArrayList<>();
        List<Character> destPath = new ArrayList<>();

        findPath(LAC, startValue, startPath);
        findPath(LAC, destValue, destPath);
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < startPath.size(); i++) {
            sb.append('U');
        }
        for (char c : destPath) {
            sb.append(c);
        }

        return sb.toString();
    }

    private boolean findPath(TreeNode root, int target, List<Character> path) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }

        path.add('L');
        boolean left = findPath(root.left, target, path);
        if (left) {
            return true;
        }
        path.remove(path.size() - 1);

        path.add('R');
        boolean right = findPath(root.right, target, path);
        if (right) {
            return true;
        }
        path.remove(path.size() - 1);

        return false;
    }

    private TreeNode getLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }

        TreeNode left = getLCA(root.left, p, q);
        TreeNode right = getLCA(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
