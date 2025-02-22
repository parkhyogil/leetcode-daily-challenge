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
    private int index, length;
    private char[] record;

    public TreeNode recoverFromPreorder(String traversal) {
        index = 0;
        length = traversal.length();
        record = traversal.toCharArray();

        return recover(0);
    }

    private TreeNode recover(int depth) {
        int i = index;
        int currDepth = 0;
        while (i < length && record[i] == '-') {
            currDepth++;
            i++;
        }

        if (currDepth != depth) {
            return null;
        }

        int value = 0;
        while (i < length && record[i] != '-') {
            value = value * 10 + record[i++] - '0';
        }

        TreeNode node = new TreeNode(value);
        index = i;

        node.left = recover(depth + 1);
        node.right = recover(depth + 1);

        return node;
    }
}
