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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        boolean[] delete = new boolean[1001];

        for (int num : to_delete) {
            delete[num] = true;
        }

        List<TreeNode> res = new ArrayList<>();

        recur(root, true, delete, res);

        return res;
    }

    private boolean recur(TreeNode node, boolean isParentDeleted, boolean[] delete, List<TreeNode> res) {
        if (node == null) {
            return false;
        }

        if (recur(node.left, delete[node.val], delete, res)) {
            node.left = null;
        }
        if (recur(node.right, delete[node.val], delete, res)) {
            node.right = null;
        }

        if (delete[node.val]) {
            node.left = null;
            node.right = null;

            return true;
        } 
        
        if (isParentDeleted) {
            res.add(node);
        }

        return false;
    }
}
