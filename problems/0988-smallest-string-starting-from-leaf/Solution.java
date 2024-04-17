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
    private String res;

    public String smallestFromLeaf(TreeNode root) {
        res = String.valueOf((char) ('z' + 1));

        recur(root, 8500, new char[8501]);

        return res;
    }

    private void recur(TreeNode root, int idx, char[] chars) {
        chars[idx] = (char) ('a' + root.val);
        
        if (root.left == null && root.right == null) {
            String s = String.valueOf(chars, idx, 8500 - idx + 1);

            if (s.compareTo(res) < 0) {
                res = s;
            }
            return;
        }

        if (root.left != null) {
            recur(root.left, idx - 1, chars);
        } 

        if (root.right != null) {
            recur(root.right, idx - 1, chars);
        }

    }
}
